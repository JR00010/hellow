package web.spring.event;

import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@Component
public class DemoListener implements ApplicationListener<DemoEvent>{


	@Override
	public void onApplicationEvent(DemoEvent event) {
		// TODO Auto-generated method stub
		String  msg = event.getMsg();
		System.out.println("��(bean-demoListener)���յ���bean-demoPublisher��������Ϣ:"+ msg);
	}

	
}
