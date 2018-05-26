package web.spring.taskexecutor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
		a.start();
		AsyncTaskService asyncTaskService =  a.getBean(AsyncTaskService.class);
		
		for(int i =0 ;i<10;i++){
			asyncTaskService.executeAsyncTask(i);
//			asyncTaskService.executeAsyncTaskPlus(i);
		}
		a.close();
	}
}
