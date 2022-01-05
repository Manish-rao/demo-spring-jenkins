package com.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Employee;
import com.demo.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	public String saveEmployee(Employee emp) {
		empRepo.save(emp);
		return "Saved Employee successfully";
	}

	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	public List<Employee> getEmpByCity(String city) {
		return empRepo.findByCityOrderByIdDesc(city);
	}

	public List<Employee> getAllEmployeesByLastName(String lastName) {
		return empRepo.findAll().stream().filter(a -> a.getLastName().equalsIgnoreCase(lastName))
				.collect(Collectors.toList());
	}
}
