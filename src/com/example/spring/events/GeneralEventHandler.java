package com.example.spring.events;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;

/** IMPORTANT NOTE **/
// Without @Configuration, spring environment will not send events to this
// handler (or any handler)

@Configuration
public class GeneralEventHandler {

	@EventListener({ ContextRefreshedEvent.class, ContextStoppedEvent.class, ContextStartedEvent.class })
	public void handleContextEvent() {
		System.out.println("############ context event fired: #################");
	}
}
