package com.example.SpringBootTask1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootTask1Application {
	public static ApplicationContext context;


	public static void main(String[] args) {
		//SpringApplication.run(SpringBootTask1Application.class, args);
		context = SpringApplication.run(SpringBootTask1Application.class, args);

        ClassKLM klm = context.getBean(ClassKLM.class);
        klm.show();
	
	    }
	}


