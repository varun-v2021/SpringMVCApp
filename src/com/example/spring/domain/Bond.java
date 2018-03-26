package com.example.spring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Bond {

	@Autowired 	//here 'Car' will be injected or autowired
	/*
	 * Without 'Qualifier' , Spring was not able to decide which bean
	 * (Ferari or Mustang as both implements Car) to choose for auto-wiring ,
	 * it throws this exception
	 * */
	@Qualifier("Mustang")
	private Car car;

	public void showCar() {
		car.getCarName();
	}
}