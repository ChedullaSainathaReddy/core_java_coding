package com.example.SpringBoot1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping
	String hello() {
		return "Spring Boot is very simple";

	}
}
