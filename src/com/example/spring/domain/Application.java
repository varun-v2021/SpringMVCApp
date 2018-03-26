package com.example.spring.domain;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component("application")
public class Application {

	/*
	 * Standard @Resource annotation marks a resource that is needed by the application
	 * It is analogous to @Autowired in that both injects beans by type when no attribute
	 * provided. But with name attribute,
	 * @Resource allows you to inject a bean by it’s name, which @Autowired does not.
	 * */
	@Resource(name = "applicationUser")
	private ApplicationUser user;
	
	/*
	 * In above code, Application’s user property is annotated with 
	 * @Resource(name=”applicationUser”). 
	 * In this case, a bean with name ‘applicationUser’ found in applicationContext 
	 * will be injected here.
	 * */

	@Override
	public String toString() {
		return "Application [user=" + user + "]";
	}
}
