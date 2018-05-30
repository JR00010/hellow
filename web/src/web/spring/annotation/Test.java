package web.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shuijun liu
 * @时间：2018年5月29日 上午11:53:16  
 * @版本：
 * @注释：   测试组合注解WiselyConfiguration 的使用 ！
 * 
 */
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(WiselyConfiguration.class);
		a.start();
		a.getBean(DemoService2.class).outPut();
		a.close();
	}
}
