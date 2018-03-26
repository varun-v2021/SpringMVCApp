package com.example.spring.domain;

import org.springframework.stereotype.Component;

@Component("Ferrari")
public class Ferrari implements Car{
 
    public void getCarName() {
        System.out.println("This is Ferari");
    }
 
}
