package com.example.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/*
 * Spring configuration class are the ones annotated with @Configuration. 
 * These classes contains methods annotated with @Bean. 
 * These @Bean annotated methods generates beans managed by Spring container.
 * */

@Configuration
@ComponentScan("com.example.spring")
//@ComponentScan(basePackages = "com.example.spring")
@PropertySource(value = { "classpath:application.properties" })
public class AppConfig {
	/*
	 * PropertySourcesPlaceHolderConfigurer Bean only required for @Value("{}")
	 * annotations. Remove this bean if you are not using @Value annotations for
	 * injecting properties.
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}

/*
 * Notice @ComponentScan which will make Spring auto detect the annotated beans
 * via scanning the specified package and wire them wherever needed
 * (using @Resource or @Autowired ).
 */

/* NOTE: Refer FileServiceImpl.java to understand ${...} and @Value(..) implementation */
/*
 * @PropertySource(value = { “classpath:application.properties” }) annotation
 * makes the properties available from named property file[s] (referred by value
 * attribute) to Spring Environment. Environment interface provides getter
 * methods to read the individual property in application. Notice the
 * PropertySourcesPlaceholderConfigurer bean method. This bean is required only
 * for resolving ${…} placeholders in @Value annotations. In case you don’t use
 * ${…} placeholders, you can remove this bean altogether.
 */

/*
 * Below are commonly used Spring annotation which makes a bean auto-detectable:
 * 
 * @Repository - Used to mark a bean as DAO Component on persistence layer
 * 
 * @Service - Used to mark a bean as Service Component on business layer
 * 
 * @Controller - Used to mark a bean as Controller Component on Presentation
 * layer
 * 
 * @Configuration - Used to mark a bean as Configuration Component.
 * 
 * @Component - General purpose annotation, can be used as a replacement for
 * above annotations.
 */
