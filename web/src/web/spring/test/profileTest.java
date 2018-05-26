package web.spring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import web.spring.config.ProfileConfig;
import web.spring.domain.DemoBean;

public class profileTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
				context.getEnvironment().setActiveProfiles("dev"); //1
				context.register(ProfileConfig.class);//2
				context.refresh(); //3
				DemoBean demoBean = context.getBean(DemoBean.class);
				System.out.println(demoBean.getJdbcUrl());
				context.close();
	}
}
