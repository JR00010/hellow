package com.frame.mcv.service;

import java.util.HashMap;
import java.util.Map;

import com.frame.exception.MethodException;
import com.frame.mcv.entry.AnnotationMethodInfo;

public interface HandlerMap {
	
	public AnnotationMethodInfo MapMethod(String rePath);

	public void excut(String servletPath, Map<String, String[]> par)throws Exception;
	
}
