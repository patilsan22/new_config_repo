package com.tradebulls.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tradebulls.entity.Category;
import com.tradebulls.entity.CustomerDetails;
import com.tradebulls.entity.Product;

public interface CartService {
		
		public Iterable<Product> saveProduct(List<Product> productList) ;
		
		public List<Category> saveCustomer(List<Category> customerList);
		
		public List<Product> getAllProduct() ;
		
		public List<Category> getAllCustomers();
		
		public void saveAllCustomerFullDetails(); 
		
	
}