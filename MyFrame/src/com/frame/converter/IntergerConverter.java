package com.frame.converter;

public class IntergerConverter implements Converter<String[],Integer>{

	@Override
	public Integer convert(String[] e) {
		Integer value = 0;
		if(e!=null){
			for (int i = 0; i < e.length; i++) {
				value = Integer.parseInt(e[0]);
			}
		}
		return value;
	}

}
