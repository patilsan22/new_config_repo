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
import com.tradebulls.service.StreamAPIService;

@RestController
@RequestMapping("/stream")
public class StreamAPIController {
	
	static Logger log = Logger.getLogger(StreamAPIController.class);
	
	@Autowired
	private StreamAPIService streamAPIService;
	
	@PostMapping("/saveOrder")
	public List<Order> saveOrder(@RequestBody List<Order> orderList){
		System.out.println("orderList :"+orderList);
		return streamAPIService.saveOrder(orderList);
	} 
	
	@PostMapping("/saveProduct")
	public List<Prod> saveProduct(@RequestBody List<Prod> productList){
		System.out.println("productList :"+productList);
		return streamAPIService.saveProduct(productList);
	}
	
	@PostMapping("/saveCustomer")
	public List<Customer> saveCustomer(@RequestBody List<Customer> customerList){
		System.out.println("customerList :"+customerList);
		return streamAPIService.saveCustomer(customerList);
	}
	
	@GetMapping("/getBook")
	public void getBooks() {
		System.out.println("// Obtain a list of product with category = \\\"Books\\\" and price > 100 (using 2 filters)\") :");
		 streamAPIService.exercise1();
	}
	
	@GetMapping("/getBooksByPredicate")
	public void getBooksByPredicate() {
		System.out.println("// Obtain a list of product with category = \\\"Books\\\" and price > 100 (using Predicate for filter)\") :");
		 streamAPIService.exercise1a();
	}
	
	@GetMapping("/getBooksByBiPredicate")
	public void getBooksByBiPredicate() {
		System.out.println("// Obtain a list of product with category = \\\"Books\\\" and price > 100 (using BiPredicate for filter)\") :");
		 streamAPIService.exercise1b();
	}
	
	@GetMapping("/getBaby")
	public void getBaby() {
		 streamAPIService.exercise2();
	}
	
	@GetMapping("/getToys")
	public void getToys() {
		 streamAPIService.exercise3();
	}
	
	@GetMapping("/getProductsBetween")
	public void getProductsBetween() {
		 streamAPIService.exercise4();
	}
	
	@GetMapping("/getProductsBetweenByRest")
	public List<Prod> getProductsBetweenByRest() {
		List<Prod> products = streamAPIService.exercise4Rest();
		if(products!= null) {
			log.info("Product founmd.."+products);
		}else {
			log.error("Product not founmd.."+products);
		}
		 return products;
	}
	
	@GetMapping("/getCheapestBook")
	public void getCheapestBooks() {
		 streamAPIService.exercise5();
	}
	
	@GetMapping("/getRecentOrder")
	public void getRecentOrder() {
		 streamAPIService.exercise6();
	}
	
	@GetMapping("/orderedOnSpecificDate")
	public void orderedOnSpecificDate() {
		 streamAPIService.exercise7();
	}
	
	// Total Sum Ordered On Specific Month
	@GetMapping("/getTotalSum")
	public void getTotalSum() {
		 streamAPIService.exercise8();
	}
	
	@GetMapping("/getTotalSumBiFunction")
	public void getTotalSumBiFunction() {
		 streamAPIService.exercise8a();
	}
	
	// 	Average Price of all orders
	@GetMapping("/getAveragePrice")
	public void getAveragePrice() {
		 streamAPIService.exercise9();
	}
	
	@GetMapping("/getAveragePriceByRest")
	public double getAveragePriceByRest() {
		 double avgPrice = streamAPIService.exercise9ByRest();
		 return avgPrice;
	}
	
	@GetMapping("/getBooksSummary")
	public void getBooksSummary() {
		 streamAPIService.exercise10();
	}
	
	@GetMapping("/getOrderProductCount")
	public void getOrderProductCount() {
		 streamAPIService.exercise11();
	}
	
	@GetMapping("/getCustomerOrder")
	public void getCustomerOrder() {
		 streamAPIService.exercise12();
	}
	
	@GetMapping("/getCustomerOrderRest")
	public void getCustomerOrderRest() throws JsonProcessingException {
		String result = streamAPIService.exercise12rest();
		
	}
	
	@GetMapping("/getCustomerOrderString")
	public String getCustomerOrderString() {
		String result = streamAPIService.exercise12restString();
		return result.toString();
	}
	
	@GetMapping("/getCustomerOrderId")
	public void getCustomerOrderID() {
		 streamAPIService.exercise12a();
	}
	
	@GetMapping("/getOrderPrice")
	public void getOrderPrice() {
		 streamAPIService.exercise13();
	}
	
	@GetMapping("/getOrderPriceByReduce")
	public void getOrderPriceByReduce() {
		 streamAPIService.exercise13a();
	}
	
	@GetMapping("/getProductNameByCategory")
	public void getProductNameByCategory() {
		 streamAPIService.exercise14();
	}
	
	//most Expensive Product per category
	@GetMapping("/getExpensiveProduct")
	public void getExpensiveProduct() {
		 streamAPIService.exercise15();
	}
	
	//most Expensive Product By Name per category
	@GetMapping("/getExpensiveProductByName")
	public void getExpensiveProductByName() {
		streamAPIService.exercise15a();
	}
	
	@GetMapping("/getAllProducts")
	public List<Prod> getAllProducts() {
		List<Prod> products = streamAPIService.getAllProduct();
		return products ;
	}
	
	@GetMapping("/getAllOrders")
	public List<Order> getAllOrders() {
		List<Order> orders = streamAPIService.getAllOrders();
		return orders;
	}
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers() {
		List<Customer> customers = streamAPIService.getAllCustomers();
		System.out.println("customers :"+customers.toString());
		return  customers;
	}


}
