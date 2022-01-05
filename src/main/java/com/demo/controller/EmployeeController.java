package com.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp){
		String response = empService.saveEmployee(emp);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees(){
		List<Employee> emps = empService.getAllEmployees();
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK); 
	}
	
	@GetMapping("/city")
	public ResponseEntity<List<Employee>> getEmployeesByCity(@RequestParam(name = "city") String city ){
		logger.info("getEmployeesByCity:{}",city);
		List<Employee> emps = empService.getEmpByCity(city);
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK); 
	}
	
	@GetMapping("/lastName")
	public ResponseEntity<List<Employee>> getEmployeesByLastName(@RequestParam(name = "lastName") String lastName ){
		logger.info("getEmployeesByLastName:{}",lastName);
		List<Employee> emps = empService.getAllEmployeesByLastName(lastName);
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK); 
	}
}
