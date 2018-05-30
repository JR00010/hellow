package web.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author shuijun liu
 * @ʱ�䣺2018��5��29�� ����10:26:10  
 * @�汾��
 * @ע�ͣ�    �����¼�����
 */
public class DemoEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -507395498074076403L;
	
	
	private String msg;

	public DemoEvent(ApplicationContext source) {
		super(source);
		// TODO Auto-generated constructor stub
	}
	public DemoEvent(Object source,String msg) {
		super(source);
		this.msg = msg;
		}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	

}
