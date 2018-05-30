package web.spring.annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * @author shuijun liu
 * @时间：2018年5月29日 上午11:07:07  
 * @版本：
 * @注释：    spring 中的元注解和组合注解使用测试 
 */
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
@EnableGlobalAuthentication
@EnableScheduling
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration //1
@ComponentScan //2
public @interface WiselyConfiguration{
	String[] value() default {}; //3
}
