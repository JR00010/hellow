package web.spring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import web.spring.config.EventConfig;
import web.spring.event.DemoPublisher;

public class EventTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(EventConfig.class);
		a.start();
		a.getBean(DemoPublisher.class).publish("love you forever");
		a.close();
	}
}
