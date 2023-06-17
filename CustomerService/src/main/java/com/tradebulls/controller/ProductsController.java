package com.tradebulls.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tradebulls.entity.Customer;
import com.tradebulls.entity.Order;
import com.tradebulls.entity.Prod;
import com.tradebulls.service.ProductsServiceImpl;
import com.tradebulls.service.StreamAPIService;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
//	static Logger log = Logger.getLogger(StreamAPIController.class);
//	
//	@Autowired
//	private ProductsServiceImpl productService ;
//	
//	@PostMapping("/saveOrder")
//	public List<Order> saveOrder(@RequestBody List<Order> orderList){
//		System.out.println("orderList :"+orderList);
//		return productService.saveOrder(orderList);
//	} 
//	
//	@PostMapping("/saveProduct")
//	public List<Prod> saveProduct(@RequestBody List<Prod> productList){
//		System.out.println("productList :"+productList);
//		return productService.saveProduct(productList);
//	}
//	
//	@PostMapping("/saveCustomer")
//	public List<Customer> saveCustomer(@RequestBody List<Customer> customerList){
//		System.out.println("customerList :"+customerList);
//		return productService.saveCustomer(customerList);
//	}
//		
//	@GetMapping("/getAllProducts")
//	public List<Prod> getAllProducts() {
//		List<Prod> products = productService.getAllProduct();
//		return products ;
//	}
//	
//	@GetMapping("/getAllOrders")
//	public List<Order> getAllOrders() {
//		List<Order> orders = productService.getAllOrders();
//		return orders;
//	}
//	
//	@GetMapping("/getAllCustomers")
//	public List<Customer> getAllCustomers() {
//		List<Customer> customers = productService.getAllCustomers();
//		System.out.println("customers :"+customers.toString());
//		return  customers;
//	}

}
