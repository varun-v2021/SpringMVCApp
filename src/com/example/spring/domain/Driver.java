package com.example.spring.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
@Component("driver")
public class Driver {
	
	//@Autowired   : autowired on field
    private License license;
    
    //@Autowired   : autowired on constructor
    /*public Driver(License license){
        this.license = license;
    }*/
    
    @Autowired //autowired on setter method
    public void setLicense(License license) {
        this.license = license;
    }
 
    @Override
    public String toString() {
        return "Driver [license=" + license + "]";
    }
    //getter
}
