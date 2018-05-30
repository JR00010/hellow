package web.spring.annotation;

import org.springframework.stereotype.Service;

@Service
public class DemoService2 {
	public void outPut() {
		System.out.println("this Bean name get from WiselyConfiguration ");
	}
}
