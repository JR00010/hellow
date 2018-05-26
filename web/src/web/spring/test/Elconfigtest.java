package web.spring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import web.spring.config.Elconfig;
import web.spring.config.ResourceConfig;

public class Elconfigtest  {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(ResourceConfig.class);
		Elconfig e = a.getBean(Elconfig.class);
		e.outputResource();
		a.close();
	}
}
