package web.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
//@ComponentScan("web.spring")
public class Diconfig {
	@Bean(initMethod="innit",destroyMethod="destroy")
	public UserFunctionService UserFunctionService(FunctionServer FunctionService) {
		UserFunctionService u = new UserFunctionService();
		u.setS(FunctionService);
		
		return u;
	}
//	@Bean
	public FunctionServer FunctionService() {
		return new FunctionServer();
	}
	

}
