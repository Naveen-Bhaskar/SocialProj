package niit.org.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc 
@ComponentScan(basePackages="com.niit") 

public class WebAppConfiguration extends WebMvcConfigurerAdapter {
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
		return new CommonsMultipartResolver();
	}

}
