package com.tradebulls.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tradebulls.entity.CustomerDetails;
import com.tradebulls.entity.Employee;
import com.tradebulls.service.CustomerService;

@RestController
@RequestMapping("/customers")
@ComponentScan("com.tradebulls.config")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
//	
//	@Autowired
//	private EmployeeService employeeService;

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		List<CustomerDetails> allCustomers = customerService.getAllCustomers();
		System.out.println(allCustomers.isEmpty());
		if (allCustomers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.ok(allCustomers);
		}
	}

	@PostMapping("/addCustomer")
	public ResponseEntity<?> addCustomerDetail(@RequestBody CustomerDetails customerDetails) {

		if (customerDetails.getCust_name() != null) {
			customerService.addCustomer(customerDetails);
			return ResponseEntity.ok(customerDetails);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/getCustomerById/{id}")
	public ResponseEntity<CustomerDetails> getCustomerById(@PathVariable(value = "id") String id) {
		if (id != null) {
			CustomerDetails customerByID = customerService.getCustomerByID(id);
			return ResponseEntity.ok(customerByID);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/saveCustomerFullDetails")
	public ResponseEntity<String> saveAllCustomerFullDetails() {
		customerService.saveAllCustomerFullDetails();
		return ResponseEntity.ok("Record added in Redis");
	}

	@DeleteMapping("deleteById/{id}")
	public String deleteRecord(@PathVariable String id) {
//		Customer customer = customerService.getCustomerByID(id);
		return customerService.deleteCustomerById(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateCustomer(@PathVariable String id, @RequestBody CustomerDetails customerDetails) {
		try {
			customerService.updateCustomerById(id, customerDetails);
			return ResponseEntity.ok("Record Updated");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getCustomerDetails/{id}")
	public ResponseEntity<List> getDetails(@PathVariable String id){
		if (id != null) {
			List<?> customerByID = customerService.getCustomerDetailsByID(id);
			return ResponseEntity.ok(customerByID);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping ("/getAddressandBankDetails/{id}")
	public ResponseEntity<?> getAddressandBankDetails (@PathVariable String id){
		Map<String, Object> customerList = customerService.getAddressandBankDetails(id);
		return ResponseEntity.ok(customerList); 
	}
	


}
