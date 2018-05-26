package web;

import org.apache.activemq.util.Suspendable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import web.spring.Diconfig;
import web.spring.UserFunctionService;

public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(Diconfig.class);
		UserFunctionService u = a.getBean(UserFunctionService.class);
		System.err.println(u.say("hello"));
		a.close();
	}
}
