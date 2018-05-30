package com.frame.mcv.entry;

import java.lang.reflect.Type;

public class Parameter {
	private Class<?> type;
	private String agr;
	private Type genericType;
	
	public Parameter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parameter(Class<?> type, Type genericType, String agr) {
		super();
		this.type = type;
		this.agr = agr;
		this.genericType = genericType;
	}

	public Class<?> getType() {
		return type;
	}
	
	public void setType(Class<?> type) {
		this.type = type;
	}
	public String getAgr() {
		return agr;
	}
	public void setAgr(String agr) {
		this.agr = agr;
	}

	public Type getGenericType() {
		return genericType;
	}

	public void setGenericType(Type genericType) {
		this.genericType = genericType;
	}
}
