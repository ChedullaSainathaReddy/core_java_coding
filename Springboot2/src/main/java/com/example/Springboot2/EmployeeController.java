package com.example.Springboot2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@GetMapping
	String hello() {
		return "Spring Boot simple as like Java";
	}
	// http://localhost:9999/emp
	@GetMapping("/emp")
	Employee getEmployee() {
		return new Employee(1, "Lakshman", 600000.00);
	}
	// http://localhost:9999/empList
	@GetMapping("/empList")
	List<Employee> getEmployees() {
		List<Employee> listEmp = new ArrayList<>();
		Employee e1 = new Employee(1, "Lakshman", 600000.00);
		Employee e2 = new Employee(2, "Anand", 700000.00);
		Employee e3 = new Employee(3, "Govind", 800000.00);
		Employee e4 = new Employee(4, "Shakeer", 900000.00);
		Employee e5 = new Employee(5, "Sriram", 800000.00);
		listEmp.add(e1);
		listEmp.add(e2);
		listEmp.add(e3);
		listEmp.add(e4);
		listEmp.add(e5);
		return listEmp;
	}


}
