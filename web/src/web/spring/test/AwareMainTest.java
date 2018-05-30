package web.spring.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.AsyncConfigurationSelector;
import org.springframework.scheduling.annotation.EnableAsync;

import web.spring.Service.AwareService;
import web.spring.config.AwareConfig;
public class AwareMainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(AwareConfig.class);
		a.start();
		a.getBean(AwareService.class).outputResult();
		a.close();
	}
}
