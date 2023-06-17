package com.tradebulls.controller;

import java.util.List;

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
import com.tradebulls.service.CustomerHmService;

@RestController
@RequestMapping("/customerHM")
public class CustomerHmController {
	
	private CustomerHmService service;
	

	public CustomerHmController(CustomerHmService service) {
		super();
		this.service = service;
	}

	@PostMapping("/addCustomer")
	public String addCustomerDetail(@RequestBody CustomerDetails customerDetails) {
			return service.addCustomer(customerDetails);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		List<CustomerDetails> allCustomers = service.getAllCustomers();
		System.out.println(allCustomers.isEmpty());
		if (allCustomers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return ResponseEntity.ok(allCustomers);
		}
	}
	
	@DeleteMapping("deleteById/{id}")
	public String deleteRecord(@PathVariable Integer id) {
//		Customer customer = customerService.getCustomerByID(id);
		return service.deleteCustomerById(id);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateCustomer(@PathVariable String id, @RequestBody CustomerDetails customerDetails) {
		try {
			service.updateCustomerById(id, customerDetails);
			return ResponseEntity.ok("Record Updated");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
