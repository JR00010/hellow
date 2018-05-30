package com.frame.sun;

import com.frame.annotation.Controller;
import com.frame.annotation.Mapping;
import com.frame.mcv.controller.book;

@Controller
@Mapping(value="ddd")
public class www {
	private int i;
	private www w;
	private book b;
	@Mapping("get")
	public void get() {
		
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public book getB() {
		return b;
	}
	public void setB(book b) {
		this.b = b;
	}
	
	public www getW() {
		return w;
	}
	public void setW(www w) {
		this.w = w;
	}
	@Override
	public String toString() {
		return "www [i=" + i + ", w=" + w + ", b=" + b + "]";
	}
	
	
	
}
