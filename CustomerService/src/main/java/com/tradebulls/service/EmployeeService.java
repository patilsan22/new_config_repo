package com.tradebulls.service;

import java.util.List;
import java.util.Map;

import com.tradebulls.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployee();
	
	public List<Employee> saveEmployee(List<Employee> list);

	double calculateAverage();

	Map<String, List<Employee>> getEmployee();

}
