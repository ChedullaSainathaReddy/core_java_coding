package com.pack1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	@RequestMapping("/")
	String hello() {
		return "index";
	}
	@ModelAttribute("course")
	public String courseName() {
		return "Java";
	}
	@RequestMapping("/addStudent")
	String addStudent(@ModelAttribute("student") Student st) {
		return "result";
	}


}
