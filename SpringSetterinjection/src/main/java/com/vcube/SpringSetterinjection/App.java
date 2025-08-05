package com.vcube.SpringSetterinjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
		Student st1 = (Student) context.getBean("st1");
		System.out.println(st1.getSid());
		System.out.println(st1.getSname());
	}

    }

