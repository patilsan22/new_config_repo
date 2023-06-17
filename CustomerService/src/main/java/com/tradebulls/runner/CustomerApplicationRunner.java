package com.tradebulls.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;

import com.tradebulls.entity.AddressDetails;
import com.tradebulls.entity.BankDetails;
import com.tradebulls.entity.CustomerDetails;
import com.tradebulls.entity.Employee;
import com.tradebulls.repo.CustomerRepository;
import com.tradebulls.service.AddressService;
import com.tradebulls.service.BankService;
import com.tradebulls.service.CustomerService;

@Component
public class CustomerApplicationRunner /*implements ApplicationRunner*/{
	
//	private CustomerRepository repository;
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private AddressService addressService;

	
//	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		List<CustomerDetails> list = new ArrayList<CustomerDetails>();
		list = Arrays.asList(
				new CustomerDetails("1","Sneha", "Mumbai", 0, 1),
				new CustomerDetails("2","Neha", "Pune", 1, 3),
				new CustomerDetails("3","John", "Delhi", 1, 2),
				new CustomerDetails("4","Kate", "Kolkatta", 0, 1),
				new CustomerDetails("5","Adam", "Chennai", 1, 2));
//		list.add(asList);
		customerService.saveCustomerDetails(list);
		
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
//		customerService.saveEmployee(empList);
		
		List<BankDetails> bankList = new ArrayList<>();
		bankList = Arrays.asList(
				new BankDetails(1, "Axis", "AXIS0000", "123456"),
				new BankDetails(2, "HDFC", "HDFC0000", "654321"));
		bankService.saveBankDetails(bankList);
		
		List<AddressDetails> addressDetails = new ArrayList<>();
		addressDetails = Arrays.asList(
				new AddressDetails(1, "Mumbai", "Maharashtra", "India", 9920265110l,
						"Sangli", "Sangli", "1"));
		addressService.saveAddressDetails(addressDetails);
		
//		Employee emp = new Employee("E101", "Rahul Dravid", "Bangalore", "Coach", 5000000);
//		Employee emp1 = new Employee("E102", "Virat Kohli", "Delhi", "Batsman", 4000000);
//		Employee emp2 = new Employee("E103", "Rohit Sharma", "Nagpur", "Batsman", 4500000);
//		Employee emp3 = new Employee("E104", "Hardik Pandya", "Baroda", "All Rounder", 3000000);
//		Employee emp4 = new Employee("E105", "Jasprit Bumrah", "Gandhi Nagar", "Bowler", 3000000);
//		Employee emp5 = new Employee("E105", "Mohammad Shami", "Delhi", "Bowler", 2500000);
//		Employee emp6 = new Employee("E105", "Umesh Yadav", "Nagpur", "Bowler", 2500000);
//		List<Employee> empDataList = List.of(emp, emp1, emp2, emp3, emp4);
	
//		CustomerServiceImpl test = new CustomerServiceImpl();
//		Map<String, List<Employee>> getEmp = test.getEmployee(empDataList);
//		System.out.println("Employee by Designation : " + getEmp);
//		
//		double avgSalary = test.calculateAverage(empDataList);
//		System.out.println("Employee Average Salary : " + avgSalary);
//	}
	
		
	}

}
