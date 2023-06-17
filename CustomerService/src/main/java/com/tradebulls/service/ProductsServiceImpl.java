package com.tradebulls.service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tradebulls.entity.Customer;
import com.tradebulls.entity.Employee;
import com.tradebulls.entity.Order;
import com.tradebulls.entity.Prod;
import com.tradebulls.repo.CustomerRepo;
import com.tradebulls.repo.OrderRepo;
import com.tradebulls.repo.ProductsRepo;

@Service
public class ProductsServiceImpl {
	
	
		@Autowired
		private CustomerRepo customerRepo;
		
		@Autowired
		ObjectMapper mapper;
	
		@Autowired
		private OrderRepo orderRepo;
	
		@Autowired
		private ProductsRepo productRepo;
	

		
		public List<Order> saveOrder(List<Order> orderList) {
			return (List<Order>) orderRepo.saveAll(orderList);
		}
		
		public List<Prod> saveProduct(List<Prod> productList) {
			return (List<Prod>) productRepo.saveAll(productList);
		}
		
		public List<Customer> saveCustomer(List<Customer> customerList) {
			return (List<Customer>) customerRepo.saveAll(customerList);
		}

		// get pending orders of Product with catagory games 
		public List<Prod> getAllProduct() {
			List<Prod> products = productRepo.findAll();
			return products;
		}
		
		public List<Order> getAllOrders() {
			List<Order> orders = orderRepo.findAll();
			return orders;
		}
		
		public List<Customer> getAllCustomers() {
			List<Customer> customers = customerRepo.findAll();
			return customers;
		}
	
	
}

