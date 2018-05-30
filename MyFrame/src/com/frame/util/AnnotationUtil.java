package com.frame.util;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

import com.frame.annotation.Mapping;
import com.frame.annotation.ResponseJson;
import com.frame.exception.AnnotionException;
import com.frame.mcv.entry.AnnotationMethodInfo;
import com.frame.mcv.entry.Parameter;



public class AnnotationUtil {
	private static String projectPath; 

	private static final List<String> packgePaths = new ArrayList<String>();

	static{
		projectPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		projectPath = projectPath.substring(projectPath.indexOf("/")+1);

	}
	private static class Path {
		private static List<String> basePaths = new ArrayList<String>();
		public static void setPath(String ...path) throws Exception {
			ClassLoader loaderd = Thread.currentThread().getContextClassLoader();
			for (String string : path) {
				String basePath= string.replace(".", "/");
				URL url = loaderd.getResource(basePath);
				if (url == null)  throw new Exception("路径有误");
				basePath  = url.getPath();
				basePath = URLDecoder.decode(basePath, "utf-8");
				basePaths.add(basePath.trim());
			}
		}

	}

	public static void setPath(String ...path) throws Exception {
		Path.setPath(path);
	}


	public static List<String>  getFilePath() throws Exception {

		List<String> basePaths = Path.basePaths;
		if (basePaths.size() != 0 ) 
			for (String string : basePaths) {
				traverseFolder2(string);
			}
		return packgePaths;
	}


	public static  List<String> traverseFolder2(String path) throws Exception {
		File file = new File(path);
		if (file.exists()) {
			File[] files = file.listFiles();
			if (files.length == 0) {
				return packgePaths;
			} else {
				for (File file2 : files) {
					if (file2.isDirectory()) {
						traverseFolder2(file2.getAbsolutePath());
					} else {
						String AbsolutefilePath  = file2.getAbsolutePath();
						AbsolutefilePath = AbsolutefilePath.replace("\\" ,"/");
						String packgePath = AbsolutefilePath.substring(AbsolutefilePath.indexOf(projectPath)+projectPath.length(),AbsolutefilePath.lastIndexOf("."));
						packgePath = packgePath.replace("/", ".");
						packgePaths.add(packgePath);
					}
				}
			}
		} else {
			throw new Exception("找不到文件");
		}
		return packgePaths;
	}
	/**
	 * 获取到注解方法的映射路径
	 * @throws ClassNotFoundException 
	 */
	public static Map<String ,AnnotationMethodInfo>  getMethodMapwith(final Class<? extends Annotation> annotation) throws Exception {
		List<Class<?>> classes =  getTypesAnnotatedWith(annotation);
		Map<String ,AnnotationMethodInfo> mapObj = new HashMap<String, AnnotationMethodInfo>();

		for (Iterator<Class<?>> iterator = classes.iterator(); iterator.hasNext();) {

			Class<?> class1 = (Class<?>) iterator.next();

			String TypePath  = null;
			String methodPath  = null;

			List<String> typeValue = new ArrayList<String>();
			List<String> methodValue = new ArrayList<String>();

			Method[] methods = class1.getDeclaredMethods();
			if(class1.isAnnotationPresent(Mapping.class)){
				Mapping con = class1.getDeclaredAnnotation(Mapping.class);
				String value = con.value();
				if(!"".equals(value)&&typeValue.contains(value)){
					throw new AnnotionException("类路劲映射出错，不能映射相同的类路径");
				}

				typeValue.add(value);
				TypePath = con.value();
			}

			for (Method method : methods) {
				String MethodName = method.getName();
				ArrayList<Parameter> parameters = getParameter(class1,method);

				if ( method.isAnnotationPresent(Mapping.class)) {
					Mapping m = method.getDeclaredAnnotation(Mapping.class);
					methodPath = m.value();
					String mapPath =   MapMethodPath(TypePath, methodPath ,methodValue);
					//					if (methodValue.contains(methodPath)) {
					//						throw new AnnotionException("方法路劲映射出错，不能映射相同的方法路径");
					//					}
					//					methodValue.add(methodPath);
					//					if (TypePath == null) {
					//						methodMap.put(methodPath, class1);
					//						continue;
					//					}
					AnnotationMethodInfo methodInfo = new AnnotationMethodInfo(class1, MethodName, parameters, method.isAnnotationPresent(ResponseJson.class));
					mapObj.put("/"+mapPath, methodInfo) ;
				}else{
					methodPath = method.getName();
					String mapPath =   MapMethodPath(TypePath, methodPath ,methodValue);
					//					if (methodValue.contains(methodPath)) {
					//						throw new AnnotionException("方法路劲映射出错，不能映射相同的方法路径");
					//					}
					//					methodValue.add(methodPath);
					//					if (TypePath == null) {
					//						methodMap.put(methodPath, class1);
					//						continue;
					//					}
					AnnotationMethodInfo methodInfo = new AnnotationMethodInfo(class1, MethodName, parameters, method.isAnnotationPresent(ResponseJson.class));
					mapObj.put("/"+mapPath, methodInfo) ;
				}
			}
		}
		return mapObj;
	}

	public static  List<Class<?>> getTypesAnnotatedWith(final Class<? extends Annotation> annotation ) throws Exception{
		List<Class<?>> classes = new ArrayList<Class<?>>();
		List<String> filePath1 = getFilePath();
		for (String string : filePath1) {
			Class<?> cl = Class.forName(string);
			if (cl.isAnnotationPresent(annotation))
				classes.add(cl);
		}
		return classes;
	}

	private  static String MapMethodPath (String type, String method ,  List<String>  c ) throws AnnotionException {
		if (c.contains(method)) {
			throw new AnnotionException("方法路劲映射出错，不能映射相同的方法路径");
		}
		c.add(method);
		if (type == null) {
			return method;
		}
		return type +"/"+method;
	}

	private static   ArrayList<Parameter> getParameter(Class<?> cl, Method method){
		ClassPool pool = ClassPool.getDefault();
		pool.insertClassPath(new ClassClassPath(cl));   
		Class<?>[] pClass =method.getParameterTypes();
		Type[] types = method.getGenericParameterTypes();
		ArrayList<Parameter> Parameters = new ArrayList<Parameter>();
		CtClass cc;
		String[] names = null;
		try {
			cc = pool.get(cl.getName());
			CtMethod cm = cc.getDeclaredMethod(method.getName());
			MethodInfo info = cm.getMethodInfo();
			CodeAttribute codeAttribute = info.getCodeAttribute();

			LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);

			int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;

			names=new String[cm.getParameterTypes().length];

			for (int i = 0; i < names.length; i++)
			{
				Parameter p = new Parameter(pClass[i], types[i], attr.variableName(i + pos));
				Parameters.add(p);
			}

		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return Parameters;
	}
}
