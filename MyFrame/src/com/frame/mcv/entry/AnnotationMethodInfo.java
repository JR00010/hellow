package com.frame.mcv.entry;

import java.util.ArrayList;

public class AnnotationMethodInfo {
	private Class<?> type;
	private String name ;
	private  Boolean isResponseJson;
	private  ArrayList<Parameter>  Parameters;
	
	
	public AnnotationMethodInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AnnotationMethodInfo(Class<?> type, String name,
			ArrayList<Parameter> parameters, Boolean isResponseJson) {
		super();
		this.type = type;
		this.name = name;
		this.Parameters = parameters;
		this.isResponseJson = isResponseJson;
	}

	public Class<?> getType() {
		
		return type;
	}
	public void setType(Class<?> type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Parameter> getParameters() {
		return Parameters;
	}
	public void setParameters(ArrayList<Parameter> parameters) {
		Parameters = parameters;
	}

	public Boolean isResponseJson() {
		return isResponseJson;
	}

	public void setIsResponseJson(Boolean isResponseJson) {
		this.isResponseJson = isResponseJson;
	}
	
}
