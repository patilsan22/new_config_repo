//package com.tradebulls.runner;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//
//import com.tradebulls.entity.Employee;
//import com.tradebulls.service.EmployeeServiceImpl;
//
//public class EmployeeRunner implements ApplicationRunner {
//	
//	@Autowired
//	EmployeeServiceImpl employeeServiceImpl;
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		// TODO Auto-generated method stub
//		
//		List<Employee> empList = new ArrayList<Employee>();
//		empList = Arrays.asList(
//				new Employee("E101", "Rahul Dravid", "Bangalore", "Coach", 5000000),
//				 new Employee("E102", "Virat Kohli", "Delhi", "Batsman", 4000000),
//				 new Employee("E103", "Rohit Sharma", "Nagpur", "Batsman", 4500000),
//				 new Employee("E104", "Hardik Pandya", "Baroda", "All Rounder", 3000000),
//				 new Employee("E105", "Jasprit Bumrah", "Gandhi Nagar", "Bowler", 3000000),
//				 new Employee("E105", "Mohammad Shami", "Delhi", "Bowler", 2500000),
//				 new Employee("E106", "Umesh Yadav", "Nagpur", "Bowler", 2500000));
//		
//		employeeServiceImpl.saveEmployee(empList);
//	}
//
//}
