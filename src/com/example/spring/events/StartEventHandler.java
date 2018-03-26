package com.example.spring.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;


@Configuration
public class StartEventHandler /*implements ApplicationListener<ContextStartedEvent>*/ {

	@EventListener
	public void onApplicationEvent(ContextStartedEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(">>>>>>>>>>>>> Context started event occurred <<<<<<<<<<<<");
	}
}
