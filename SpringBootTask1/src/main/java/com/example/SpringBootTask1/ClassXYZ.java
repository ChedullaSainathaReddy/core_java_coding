package com.example.SpringBootTask1;

import org.springframework.stereotype.Component;

@Component("classXYZ")
public class ClassXYZ implements InterfacePQR {
	@Override
    public void display() {
        System.out.println("Hi, I am ClassXYZ");
    }
	

}
