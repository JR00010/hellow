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
		System.out.println("我(bean-demoListener)接收到了bean-demoPublisher发布的消息:"+ msg);
	}

	
}
