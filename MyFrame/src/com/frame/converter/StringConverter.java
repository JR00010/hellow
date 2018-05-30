package com.frame.converter;

public class StringConverter implements Converter<String[], String> {

	@Override
	public String convert(String[] e) throws Exception {
		String str = "";
		if(e!=null&&e.length==1){
			for (int i = 0; i < e.length; i++) {
				str = e[0];
			}
		}else if(e!=null&&e.length!=1){
			throw new Exception("参数String类型转换错误");
		}

		return str;
	}

}
