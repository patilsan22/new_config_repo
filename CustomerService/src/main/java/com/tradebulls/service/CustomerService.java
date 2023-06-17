package com.tradebulls.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.tradebulls.entity.CustomerDetails;
import com.tradebulls.entity.Employee;

public interface CustomerService {
	public void addCustomer(CustomerDetails customerDetails);

	public List<CustomerDetails> getAllCustomers();

	public void saveCustomerDetails(List<CustomerDetails> list);

	public CustomerDetails getCustomerByID(String id);

	public String deleteCustomerById(String id);

	public void updateCustomerById(String id, CustomerDetails customerDetails);
	
	public  List<Map<String, Object>> getCustomerDetailsByID(String id);
	
	public Map<String, Object> getAddressandBankDetails(String cust_id);
	
	public void saveAllCustomerFullDetails();
	
}
