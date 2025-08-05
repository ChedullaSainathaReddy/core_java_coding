package com.example.SpringBootTask1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
@Component
public class ExampleConfig {
	 @Value("${app.example.integer-value}")
	    private Integer valueInteger;

	    @Value("${app.example.decimal-value}")
	    private Double valueDouble;

	    @Value("${app.example.boolean-value}")
	    private Boolean valueBoolean;

	    // Getters for testing or injection into other components
	    public Integer getValueInteger() {
	        return valueInteger;
	    }

	    public Double getValueDouble() {
	        return valueDouble;
	    }

	    public Boolean getValueBoolean() {
	        return valueBoolean;
	    }
	    @PostConstruct
	    public void init() {
	        System.out.println("Integer Value: " + valueInteger);
	        System.out.println("Decimal Value: " + valueDouble);
	        System.out.println("Boolean Value: " + valueBoolean);
	    }
 
	

}
