package web.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author shuijun liu
 * @时间：2018年5月29日 上午10:26:10  
 * @版本：
 * @注释：    测试事件监听
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
