package com.frame.test;

import java.lang.reflect.Method;

import com.frame.annotation.Controller;
import com.frame.annotation.Mapping;
import com.frame.mcv.Aaa;
import com.frame.mcv.controller.book;
import com.frame.util.AnnotationUtil;

public class UtilTest {
	public static void main(String[] args) throws Exception {
//		AnnotationUtil.setPath("com.frame.annotation");
//		AnnotationUtil.getRequestMapping();
//		AnnotationUtil.setPath("com.frame.sun" ,"com.frame.annotation" ,"com.frame.test" ,"com.frame.mcv");
//		AnnotationUtil.setPath( "com.frame.mcv.controller");
//		AnnotationUtil.getMethodMapwith(Controller.class);
		
		Method d = book.class.getMethod("get");
		d.invoke(book.class.newInstance());
		
		
//		Method  m = new Aaa().getClass().getDeclaredMethod("wwww");
//		m.invoke(new Aaa().getClass().newInstance());
		
//		String ss = "D:/Workspaces/MyFrame/WebRoot/WEB-INF/classes/com/frame/annotation/Controller.class";
//		System.err.println(ss.indexOf("/Workspaces/MyFrame/WebRoot/WEB-INF/classes/"));
//		ss = ss.substring(ss.indexOf("classes/")+1);
//		System.err.println(ss);
//		Class c = Aaa.class;
//		
//		Method[] m = c.getDeclaredMethods();
//		
//		
//		for (Method method : m) {
//			System.err.println(method.getName());
//			Boolean b = method.isAnnotationPresent(Mapping.class);
//			if (b) {
//				Mapping M = method.getDeclaredAnnotation(Mapping.class);
//				System.err.println(M.value());
//			}
//		}
		
		
		
		
	}
	
	
	
}
