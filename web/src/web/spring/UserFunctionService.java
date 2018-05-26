package web.spring;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;



//@Service
public class UserFunctionService {
//	@Resource
	private FunctionServer s ;
	public void innit() {
		System.err.println("@Bean innit");
	}
	public void destroy() {
		System.err.println("@Bean destroy");
	}
	public String say(String s) {
		return this.s.sayhello();
	}
	public FunctionServer getS() {
		return s;
	}

	public void setS(FunctionServer s) {
		this.s = s;
	}
	
}
