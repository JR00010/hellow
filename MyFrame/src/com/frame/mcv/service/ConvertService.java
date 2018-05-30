package com.frame.mcv.service;

import java.util.ArrayList;
import java.util.List;

import com.frame.converter.Converter;
import com.frame.exception.ConverterException;

public  interface ConvertService {
	
	public Converter<String[], ?> getConverter(Class<?> clz, String[] str) throws ConverterException;
	
	public void addCustomConverter(Converter<String[], ?> c);
	
}
