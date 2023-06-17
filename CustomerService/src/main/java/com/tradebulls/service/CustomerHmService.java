package com.tradebulls.service;

import java.util.List;

import com.tradebulls.entity.CustomerDetails;

public interface CustomerHmService {
	public String addCustomer(CustomerDetails customerDetails);

	public List<CustomerDetails> getAllCustomers();
	
	public String deleteCustomerById(Integer id);
	
	public String updateCustomerById(String id, CustomerDetails customerDetails);
}
