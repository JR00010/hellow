package web.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author shuijun liu
 * @ʱ�䣺2018��5��29�� ����11:53:16  
 * @�汾��
 * @ע�ͣ�   �������ע��WiselyConfiguration ��ʹ�� ��
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
