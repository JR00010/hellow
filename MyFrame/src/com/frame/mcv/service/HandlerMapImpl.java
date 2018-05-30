package com.frame.mcv.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.frame.annotation.Controller;
import com.frame.converter.Converter;
import com.frame.converter.StringArrayConverter;
import com.frame.converter.StringConverter;
import com.frame.mcv.entry.AnnotationMethodInfo;
import com.frame.mcv.entry.Parameter;
import com.frame.test.TypeToolsTest;
import com.frame.util.AnnotationUtil;
import com.frame.util.PropertiesUtill;
import com.frame.util.StringUtill;
import com.google.common.base.Objects;

/**
 * @author shuijun liu
 * @时间：2017年8月30日 下午5:58:44  
 * @版本：
 * @注释：    
 */
public class HandlerMapImpl implements HandlerMap {
	private static   Map<String, AnnotationMethodInfo> methodPathsMap ;
		
	static{
		try {
			String[] packages = PropertiesUtill.getScannerPath();
			AnnotationUtil.setPath(packages);
			methodPathsMap = AnnotationUtil.getMethodMapwith(Controller.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public void excut(String path,Map<String, String[]> par) throws Exception {
		ConvertServiceimpl.newInstance().addCustomConverter(new StringArrayConverter());
		HandlerMap hm = new HandlerMapImpl();
//		AnnotationMethodInfo method = hm.MapMethod("book/get");
		AnnotationMethodInfo method = hm.MapMethod(path);
		System.err.println(method.isResponseJson());
//		Map<String, String[]> par = new HashMap<String, String[]>();
		
//		par.put("d", new String[]{"1231231","hdfjkhl"});
//		par.put("i", new String[]{"12"});
//		par.put("b.er", new String[]{"5555555"});
////		par.put("w.i", new String[]{"6666666"});
//		par.put("b.b.er", new String[]{"5555555666"});
//		par.put("b.b.b.er", new String[]{"333333333333"});
		Class<?> cl = method.getType();
		ArrayList<Parameter> parameters =  method.getParameters();
		
		int num = parameters.size();
		Class<?>[] pcl= new Class[num];
		Object[] obj = ((HandlerMapImpl) hm).Mapparmater(parameters,par);
		for (int i = 0; i < pcl.length; i++) {
			pcl[i] = parameters.get(i).getType();
			
		}
		Method m = cl.getMethod(method.getName(), pcl);
        m.invoke(cl.newInstance(),obj);
        
        //首先判断形参的类型
	}

	public AnnotationMethodInfo MapMethod(String rePath ) {
		AnnotationMethodInfo  Instance= methodPathsMap.get(rePath);
		if (Instance == null) return null;   //这个地方应该返回一个404 找不到路径视图
		return Instance;
	}
	
	
	/**映射方法参数
	 * @return
	 * @throws Exception 
	 */
	private  Object[] Mapparmater(ArrayList<Parameter> agr, Map<String, String[]> parameter) throws Exception{
		Object[] obj= new Object[agr.size()];
		
		for (int i = 0; i < agr.size(); i++) {
			Parameter p = agr.get(i);
			
			Class<?> clz = p.getType();//参数Class
			String agrStr = p.getAgr(); //参数名
//			if(clz.newInstance() instanceof Collection){
//				System.err.println("yse");
//			}
//			ParameterizedType pt = (ParameterizedType) p.getGenericType();
//			String ss = pt.getActualTypeArguments()[0].getTypeName();
			if(!isJavaClass(clz)){
				Object o = getFileMapValue(clz, parameter);
				obj[i] = o;
			}else{
				String[] strArray = parameter.get(agrStr);
				ConvertService converterService = ConvertServiceimpl.newInstance();
				Converter<String[], ?> c = converterService.getConverter(clz, strArray);
				Object o = c.convert(strArray);
				obj[i] = o;
	
			}
		}
		return obj;
	}
	/** 判断是不是java自带类型，如果是返回true，比如int，Integer属于java自带类
	 * @param clz
	 * @return 
	 */
	private  boolean isJavaClass(Class<?> clz) {  
		    return clz != null && clz.getClassLoader() == null;  
	}  
	
	/**  获取到有封装参数的请求参数值。
	 * @param clz
	 * @param parameter
	 * @return
	 * @throws Exception 
	 */
	public  Object getFileMapValue(Class<?> clz, Map<String, String[]> parameter) throws Exception{
		Field[] fs = clz.getDeclaredFields();
		Object o = clz.newInstance();
		
		fs = conductName(clz.getName(),fs);
		
		for (Field field : fs) {
			String name = field.getName();
			if(!isJavaClass(field.getType() )){
				//获取成员变量，继续遍历匹配值 
				Boolean flag = ishasMapFiled(name, parameter);
				if(!flag){
					
					Method m = clz.getDeclaredMethod("set"+StringUtill.StringToWord(name), field.getType());
					m.invoke(o,new Object[]{null});
				}else{
					subFiledName(name, parameter);
					
					Object obj = getFileMapValue(field.getType(),parameter);
					
					Method m = clz.getDeclaredMethod("set"+StringUtill.StringToWord(name), field.getType());
					m.invoke(o,obj);
				}
				
				
			}else{
				//获取类型转换器
				ConvertService converterService = ConvertServiceimpl.newInstance();
				String[] value = parameter.remove(name);
				Converter<String[], ?> converter = converterService.getConverter(field.getType(), value);
				
				//得到转换值！
				Object obj =  converter.convert(value);
				
				//封装到实列中 
				Method m = clz.getDeclaredMethod("set"+StringUtill.StringToWord(name), field.getType());
				m.invoke(o, obj);
			}
			
		}
		
		return o;
		
	}
	
	/** 参数数组处理 ，如果参数类型与类类型一样，往数组后面排
	 * @param name
	 * @param fs
	 * @return
	 */
	private Field[] conductName(String name, Field[] fs) {
		for (int i = 0; i < fs.length-1; i++) {
			String s  = fs[i].getType().getName();
			if(name.equals(s)){
				Field temp = fs[i+1];
				fs[i+1] = fs[i];
				fs[i] = temp;
			}
		}
		return fs;
	}

	/**  处理参数名与请求参数 ，如果当前的参数是封装类型，且请求参数有当前的参数值，则把请求参数名与分装参数名字一一对应
	 * @param name 参数名 
	 * @param parameter
	 */
	private void subFiledName(String name, Map<String, String[]> parameter){
		Set<String> keyset = parameter.keySet();
		Map<String, String[]> newMap = new HashMap<String, String[]>();
		ArrayList<String> li = new ArrayList<String>();
		for (String string : keyset) {
			Boolean flag = string.startsWith(name);
			if(flag){
				String reName = string.substring(string.indexOf(name)+name.length()+1);
				if(StringUtill.isBank(reName)){
					continue;
				}
				li.add(string);
				newMap.put(reName, parameter.get(string));
			}
		}
		
		for (String string : li) {
			parameter.remove(string);
		}
		parameter.putAll(newMap);
		
	}
	
	/** 判断参数是否在请求参数中 
	 * @param name
	 * @param parameter
	 * @return
	 */
	private Boolean ishasMapFiled(String name, Map<String, String[]> parameter){
		Boolean flag = false;
		Set<String> keyset = parameter.keySet();
		for (String string : keyset) {
			flag = string.startsWith(name);
			if(flag)
				break;
		}
		return flag;
		
	}
}
