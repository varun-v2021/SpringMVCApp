package com.example.spring.events;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Configuration
public class StopEventHandler /*implements ApplicationListener<ContextStoppedEvent>*/ {

	@EventListener
	public void onApplicationEvent(ContextStoppedEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(">>>>>>>>>>>>> Context stopped event occurred <<<<<<<<<<<<");
	}

}
