package com.frame.mcv.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import org.hibernate.validator.util.NewInstance;

import com.frame.converter.Converter;
import com.frame.exception.ConverterException;
import com.frame.util.ConverterFactory;

public class ConvertServiceimpl  implements ConvertService{
	
	private  ArrayList<Converter<String[], ?>> converters = new ArrayList<Converter<String[],?>>();
	
	private static ConvertService convertService = new ConvertServiceimpl();;
	
	

	private  ConvertServiceimpl() {
		super();
	}
	
	public static ConvertService newInstance(){
		
		return convertService;
	}

	@Override
	public Converter<String[], ?> getConverter(Class<?> clz, String[] str) throws ConverterException {
		String name = clz.getTypeName();
		Converter<String[], ?> c= getCustomConverter(name);
		
		return c!=null? c:new ConverterFactory().getConverter(name);
		
	}
	
	
	public Converter<String[], ?> getCustomConverter(String name){
		for (Iterator<Converter<String[], ?>> iterator = converters.iterator(); iterator.hasNext();) {
			Converter<String[], ?> converter = (Converter<String[], ?>) iterator
					.next();
			
			 ParameterizedType parameterizedType = (ParameterizedType) converter.getClass().getGenericInterfaces()[0];  
			 Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();  
				 String name1 = actualTypeArguments[1].getTypeName();
			     if (Objects.equals(name, name1)) {
					return converter;
				}
		}
		return null;
	}

	public ArrayList<Converter<String[], ?>> getConverters() {
		return converters;
	}

	public void setConverters(ArrayList<Converter<String[], ?>> converters) {
		this.converters = converters;
	}

	@Override
	public void addCustomConverter(Converter<String[], ?> c) {
		converters.add(c);
	}
	
}
