package com.vcube.SpringConstructorInjection;

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
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Customer c1 = (Customer) context.getBean("cus1");
		c1.show();
		Customer c2 = (Customer) context.getBean("cus2");
		c2.show();
		
		Customer c3 = (Customer) context.getBean("cus3");
		c3.show();
	}

    }

