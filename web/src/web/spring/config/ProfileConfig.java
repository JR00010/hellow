package web.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import web.spring.domain.DemoBean;
@Configuration
//@PropertySource("classpath:web/test.propertis")
@ComponentScan("web.spring.config")
public class ProfileConfig {
//	@Value("${jdbc.url}") //7
//	private String bookName;
	@Autowired
	private Environment environment; //7
	@Bean //7
	public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	@Bean
	@Profile("dev") //1
	public DemoBean devDemoBean(ElconfigDve d) {
		System.err.println("dev config");
		DemoBean b = new DemoBean();
		b.setJdbcUrl(d.getUrl());
		b.setBookNeme(d.getBookName());
		return b;
	}
	@Bean
	@Profile("prod") //2
	public DemoBean prodDemoBean(ElconfigProd d) {
		System.err.println("prod config");
		DemoBean b = new DemoBean();
		b.setJdbcUrl(d.getUrl());
		b.setBookNeme(d.getBookName());
		return b;
	}
}
