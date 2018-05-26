package web.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class DemoPublisher {
	@Autowired
	ApplicationContext applicationContext; //1
	
	public void publish(String msg){
		
		applicationContext.publishEvent(new DemoEvent(this, msg)); //2
		
	}
}