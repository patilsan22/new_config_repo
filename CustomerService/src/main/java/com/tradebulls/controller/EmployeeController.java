package com.tradebulls.controller;
	
	import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import com.tradebulls.entity.Employee;
	import com.tradebulls.service.EmployeeServiceImpl;

	@RestController
	@RequestMapping("/employees")
	public class EmployeeController {
		
		static Logger log = Logger.getLogger(EmployeeController.class);
		
		@Autowired
		private EmployeeServiceImpl employeeServiceImpl;
		
	//	
//		@Autowired
//		private EmployeeService employeeService;

		@GetMapping("/getAll")
		public List<Employee> getAll() {
			List<Employee> empDataList = employeeServiceImpl.getAllEmployee();
			System.out.println("empDataList :"+ empDataList);
			log.info("empDataList :"+ empDataList);
			return empDataList;

		}
		
		@GetMapping("/getById/{id}")
		public Optional<Employee> getById(@PathVariable String id) {
			Optional<Employee> emp = employeeServiceImpl.getEmployeeById(id);
			System.out.println("emp :"+ emp);
			return emp;

		}
		
		@PostMapping("/saveEmp")
		public List<Employee> saveEmp(@RequestBody List<Employee> empList){
			System.out.println("empList :"+empList);
			return employeeServiceImpl.saveEmployee(empList);
		}
		
		
		@GetMapping("/getEmpByTitle")
		public Map<String, List<Employee>> getEmpByTitle() {
			Map<String, List<Employee>> empDataList = employeeServiceImpl.getEmployee();
			System.out.println("empDataList :"+ empDataList);
			return empDataList;
		}
		
		@GetMapping("/getAverageSalaries")
		public double getAverageSalaries() {
			double empAvgSalary = employeeServiceImpl.calculateAverage();
			System.out.println("Employee Average Salary :"+ empAvgSalary);
			return empAvgSalary;
		}
		
		

		

}
