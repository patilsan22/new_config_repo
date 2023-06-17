package com.tradebulls.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradebulls.entity.Employee;
import com.tradebulls.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public Map<String, List<Employee>> getEmployee() {
		List<Employee> empDataList = employeeRepo.findAll();
		return empDataList.stream().collect(Collectors.groupingBy(Employee::getTitle));
	}
	
	@Override
	public double calculateAverage() {
		List<Employee> employeeList = employeeRepo.findAll();
		return employeeList.stream().mapToInt(employee -> employee.getSalary()).average().getAsDouble();
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}
	
	public Optional<Employee> getEmployeeById(String id) {
		// TODO Auto-generated method stub
		return employeeRepo.findByName(id);
	}

	@Override
	public List<Employee> saveEmployee(List<Employee> list) {
		return employeeRepo.saveAll(list);
		
	}
}
