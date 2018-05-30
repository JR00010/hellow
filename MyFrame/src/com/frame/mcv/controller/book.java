package com.frame.mcv.controller;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle.Control;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

import com.frame.annotation.Controller;
import com.frame.annotation.Mapping;
import com.frame.annotation.ResponseJson;
import com.frame.sun.www;

@Controller
@Mapping("book")
public class book {
	
	private  String er;
	private  book b;
	private static final Control INSTANCE = new Control();
	
	
	public @ResponseJson Integer setBook(String str) {
		System.err.println(str);
		return null;
	}
	
	public void get3(ArrayList<String> list) {
		
	}
	@Mapping("get")
	public void get1(String str,int i,String uuu, www w,String[] d) {
		System.err.println(i);
		System.err.println(str);
		System.err.println(uuu);
		System.err.println(w);
		System.err.println(Arrays.toString(d));
	}
	
		   public static void main(String[] args) {
		       getMethodInfo("java.util.HashSet");
		   }
		   
		   @SuppressWarnings("rawtypes")
		   private static void getMethodInfo(String pkgName) {
//		       try {
//		           Class clazz = Class.forName(pkgName);
//		           Method[] methods = clazz.getMethods();
//		           for (Method method : methods) {
//		               String methodName = method.getName();
//		               System.out.println("方法名称:" + methodName);
//		               Class<?>[] parameterTypes = method.getParameterTypes();
//		               for (Class<?> clas : parameterTypes) {
//		                   String parameterName = clas.getName();
//		                   System.out.println("参数名称:" + parameterName);
//		               }
//		               System.out.println("*****************************");
//		           }
//		       } catch (ClassNotFoundException e) {
//		           e.printStackTrace();
//		       }
		       
		       
		       book b = new book();
//		       b.get3(new List());
		       try {
		    	   Method m= book.class.getDeclaredMethod("setBook",String.class);
		    	   AnnotatedType v = m.getAnnotatedReturnType();
		    	   System.err.println(m.isAnnotationPresent(ResponseJson.class)+"ffff");
		    	   Mapping[] d = m.getAnnotationsByType(Mapping.class);
		    	   
		    	   for (int i = 0; i < d.length; i++) {
					
					System.err.println(d[i].value());
				}
		    	   v.getAnnotationsByType(Mapping.class);
		    	  System.err.println(v.getType().getTypeName());
//		    	   Mapping[] m2 =  v.getAnnotationsByT
		    	   System.err.println(v.getType()+"0000000");v.getType().getTypeName();
				
			} catch (NoSuchMethodException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SecurityException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		       
		      
		       
		       
		       
		       
		       
		       ClassPool pool = ClassPool.getDefault();
		       
		       CtClass cc;
		       
		       try {
		    	 System.err.println(book.class.getName());
		        cc = pool.get(book.class.getName());
		        
		        CtMethod cm = cc.getDeclaredMethod("get1");
		        
		        MethodInfo info = cm.getMethodInfo();
		        
		        CodeAttribute codeAttribute = info.getCodeAttribute();
		        
		        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);

		        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;

		        String[] names=new String[cm.getParameterTypes().length];
		        
		        for (int i = 0; i < names.length; i++)
		        {
		         names[i] = attr.variableName(i + pos);
		         
		         System.out.println(names[i]);
		        }
		        
		       } catch (NotFoundException e) {
		        e.printStackTrace();
		       }
		   }

		public book getB() {
			return b;
		}

		public void setB(book b) {
			this.b = b;
		}

		public String getEr() {
			return er;
		}

		public void setEr(String er) {
			this.er = er;
		}

		@Override
		public String toString() {
			return "book [b=" + b + ", er=" + er + "]";
		}
		public static class Control {   
	        protected Control() {
	        	
	        } 
	         public void  de() {
				
			}
		 }
}
