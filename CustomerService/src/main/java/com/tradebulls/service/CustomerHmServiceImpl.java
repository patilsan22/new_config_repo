package com.tradebulls.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tradebulls.entity.CustomerDetails;

@Service
public class CustomerHmServiceImpl implements CustomerHmService {

	Map<String, CustomerDetails> map = new HashMap<>();

	@Override
	public String addCustomer(CustomerDetails customerDetails) {
		String key = customerDetails.getCust_ID();
		if(map.containsKey(key)) {
			return "Customer already present";
		}else {
			map.put(key, customerDetails);
			return "Record added successfully";
		}
		
	}

	@Override
	public List<CustomerDetails> getAllCustomers() {
		List<CustomerDetails> custList = new ArrayList<CustomerDetails>();
		for(CustomerDetails customerDetails : map.values()) {
			custList.add(customerDetails);
		}
		return custList;
	}

	@Override
	public String deleteCustomerById(Integer id) {
		if (map.containsKey(id)) {
			map.remove(id);
			return "Record deleted successfully";
		} else {
			return "No such record with id " + id + " found";
		}
	}

	@Override
	public String updateCustomerById(String id, CustomerDetails customerDetails) {
		if (map.containsKey(id)) {
			map.put(id, customerDetails);
			return "Record updated successfully";
		}else {
			return "No such record with id " + id + " found";
		}
		
	}

	
}
