package com.frame.mcv.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

import com.frame.mcv.entry.AnnotationMethodInfo;
import com.frame.mcv.service.HandlerMap;
import com.frame.mcv.service.SummerContext;
import com.frame.sun.www;

public class Dispatcher {
//	public static void main(String[] args) {
//		System.err.println(Dispatcher.class.getClassLoader()==null);
//			
//	}
	public void getExecuteMethod (HandlerMap HP) {
		
	}
	
	public void Execute(SummerContext context) {
		HandlerMap handlerMap = context.getHandlerMapping();
		AnnotationMethodInfo methodInfo = handlerMap.MapMethod("");
		if(methodInfo==null){
			//∑µªÿ¥ÌŒÛ ”Õº
		}else{
			
		}
		
	}
	 public static boolean isJavaClass(Class<?> clz) {  
		    return clz != null && clz.getClassLoader() == null;  
		  }  
	 
	 
	  public static void main(String... args) throws InstantiationException, IllegalAccessException {  
//		    System.out.println(isJavaClass(Integer.class)); // true  
//		    System.out.println(isJavaClass(book.class));// false
//		    System.out.println(isJavaClass(Arrays.class)); 
//		    System.out.println(isJavaClass(Integer.class)); 
//		    System.out.println(isJavaClass(Arrays.class)); 
//		    System.out.println(ArrayList.class.getClassLoader());
//		    
//		    
//		    
//		    System.err.println("1234564".startsWith("123453"));
		  
//		  
//		  Class<?> clz = www.class;
//		  Field[] fs = clz.getDeclaredFields();
//		  Object o = clz.newInstance();
//		  for (Field field : fs) {
//			System.err.println(field.getName());
//			clz.getDeclaredMethod("get"+field.getName(), parameterTypes)
//		}
		  } 
}

