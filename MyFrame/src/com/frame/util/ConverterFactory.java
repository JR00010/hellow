package com.frame.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.frame.converter.Converter;
import com.frame.converter.IntergerConverter;
import com.frame.converter.StringConverter;
import com.frame.exception.ConverterException;

public class ConverterFactory {
	
	public Converter<String[], ?> getConverter(String typeName) throws ConverterException {
		
		switch (typeName) {
		case "java.lang.Integer":
			
			return new IntergerConverter();
		case "java.lang.String":
			
			return new StringConverter();
		case "int":
			
			return new IntergerConverter();

		default:
			throw new ConverterException("不能转换的参数类型 :"+typeName);
		}
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		String dd = ConverterFactory.class.getTypeName();
		Class<?> c = Class.forName(dd);
		System.err.println(c.getName()+"++++++++++");
		System.err.println(ConverterFactory.class.getTypeName());
		System.err.println(Double.class.getTypeName());
		System.err.println(int.class.isPrimitive());
		System.err.println(int.class.getClassLoader());
		System.err.println(int.class.isMemberClass());
		
		
		IntergerConverter in = new IntergerConverter();
		in.getClass();
//		 System.out.println(in.getClass().getGenericSuperclass()); 
		 
		 
		 
		 ParameterizedType parameterizedType = (ParameterizedType) in.getClass().getGenericInterfaces()[0];  
		 System.err.println(parameterizedType);
		 Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();  
		 for (Type actualTypeArgument : actualTypeArguments) {  
		     System.out.println(actualTypeArgument.getTypeName());  
		 }  
	}
}
