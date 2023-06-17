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
public class StreamAPIService {
	
	
		@Autowired
		private CustomerRepo customerRepo;
		
		@Autowired
		ObjectMapper mapper;
	
		@Autowired
		private OrderRepo orderRepo;
	
		@Autowired
		private ProductsRepo productRepo;
	
//		@Test
//		@DisplayName("Obtain a list of product with category = \"Books\" and price > 100")
//		public void exercise1() {
//			long startTime = System.currentTimeMillis();
//			List<Product> result = productRepo.findAll()
//			.stream()
//			.filter(p -> p.getCategory().equalsIgnoreCase("Books"))
//			.filter(p -> p.getPrice() > 100)
//			.collect(Collectors.toList());
//			long endTime = System.currentTimeMillis();
//	
//			log.info(String.format("exercise 1 - execution time: %1$d ms", (endTime - startTime)));
//			result.forEach(p -> log.info(p.toString()));
//		}
		
		public List<Order> saveOrder(List<Order> orderList) {
			return (List<Order>) orderRepo.saveAll(orderList);
		}
		
		public List<Prod> saveProduct(List<Prod> productList) {
			return (List<Prod>) productRepo.saveAll(productList);
		}
		
		public List<Customer> saveCustomer(List<Customer> customerList) {
			return (List<Customer>) customerRepo.saveAll(customerList);
		}
		
		public void exercise1() {
			long startTime = System.currentTimeMillis();
			List<Prod> result = productRepo.findAll()
			.stream()
			.filter(p -> p.getCategory().equalsIgnoreCase("Books"))
			.filter(p -> p.getPrice() > 100)
			.collect(Collectors.toList());
			long endTime = System.currentTimeMillis();	
			System.out.println("exercise1 : ");
			result.forEach(p -> System.out.println(p.toString()));
		}
	
		// Obtain a list of product with category = \"Books\" and price > 100 (using Predicate chaining for filter)")
		public void exercise1a() {
			Predicate<Prod> categoryFilter = product -> product.getCategory().equalsIgnoreCase("Books");
			Predicate<Prod> priceFilter = product -> product.getPrice() > 100;
	
			long startTime = System.currentTimeMillis();
			List<Prod> result = productRepo.findAll()
					.stream()
					.filter(product -> categoryFilter.and(priceFilter).test(product))
					.collect(Collectors.toList());
			long endTime = System.currentTimeMillis();
			System.out.println("exercise1a : ");
			result.forEach(p -> System.out.println(p.toString()));
		}
	
		// Obtain a list of product with category = \"Books\" and price > 100 (using BiPredicate for filter)")
		public void exercise1b() {
			BiPredicate<Prod, String> categoryFilter = (product, category) -> product.getCategory().equalsIgnoreCase(category);
	
			long startTime = System.currentTimeMillis();
			List<Prod> result = productRepo.findAll()
					.stream()
					.filter(product -> categoryFilter.test(product, "Books") && product.getPrice() > 100)
					.collect(Collectors.toList());
			long endTime = System.currentTimeMillis();
			System.out.println("exercise1b : ");
			result.forEach(p -> System.out.println(p.toString()));
		}
	
		// Obtain a list of order with product category = \"Baby\"")
		public void exercise2() {
			long startTime = System.currentTimeMillis();
			
			List<Order> result = orderRepo.findAll()
					.stream()
					.filter(o ->
						o.getProducts()
						.stream()
						.anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby"))
					)
					.collect(Collectors.toList());
			long endTime = System.currentTimeMillis();
			System.out.println("exercise2 : ");
			result.forEach(o -> System.out.println(o.toString()));
		}
	
		// "Obtain a list of product with category = “Toys” and then apply 10% discount\"")
		public void exercise3() {
			long startTime = System.currentTimeMillis();
	
			List<Prod> result = productRepo.findAll()
					.stream()
					.filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
					.map(p -> p.withPrice(p.getPrice() * 0.9))
					.collect(Collectors.toList());
			long endTime = System.currentTimeMillis();
			System.out.println("exercise3 : ");
			result.forEach(o -> System.out.println(o.toString()));
	
		}

		// Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021")
		public void exercise4() {
			long startTime = System.currentTimeMillis();
			List<Prod> result = orderRepo.findAll()
			.stream()
			.filter(o -> o.getCustomer().getTier() == 2)
			.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
			.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
			.flatMap(o -> o.getProducts().stream())
			.distinct()
			.collect(Collectors.toList());
	
			long endTime = System.currentTimeMillis();
			System.out.println("exercise4 : ");
			result.forEach(o -> System.out.println(o.toString()));
		}
		
		public List<Prod> exercise4Rest() {
			long startTime = System.currentTimeMillis();
			List<Prod> result = orderRepo.findAll()
			.stream()
			.filter(o -> o.getCustomer().getTier() == 2)
			.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
			.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
			.flatMap(o -> o.getProducts().stream())
			.distinct()
			.collect(Collectors.toList());
	
			long endTime = System.currentTimeMillis();
			System.out.println("exercise4 : ");
			return result;
		}
	
		// "Get the 3 cheapest products of \"Books\" category")
		public void exercise5() {
		long startTime = System.currentTimeMillis();
	//              Optional<Product> result = productRepo.findAll()
	//                              .stream()
	//                              .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
	//                              .sorted(Comparator.comparing(Product::getPrice))
	//                              .findFirst();
	
			Optional<Prod> result = productRepo.findAll()
					.stream()
					.filter(p -> p.getCategory().equalsIgnoreCase("Books"))
					.min(Comparator.comparing(Prod::getPrice));
	
			long endTime = System.currentTimeMillis();
			System.out.println("exercise5 : " + result.get().toString()); 
		}
	
		// Get the 3 most recent placed order")
		public void exercise6() {
			long startTime = System.currentTimeMillis();
			List<Order> result = orderRepo.findAll()
					.stream()
					.sorted(Comparator.comparing(Order::getOrderDate).reversed())
					.limit(3)
					.collect(Collectors.toList());
	
			long endTime = System.currentTimeMillis();
			System.out.println("exercise6 : ");
			result.forEach(o -> System.out.println(o.toString()));
		}
	
		// "Get a list of products which was ordered on 15-Mar-2021")
		public void exercise7() {
			long startTime = System.currentTimeMillis();
			List<Prod> result = orderRepo.findAll()
					.stream()
					.filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
					.peek(o -> System.out.println(o.toString()))
					.flatMap(o -> o.getProducts().stream())
					.distinct()
					.collect(Collectors.toList());
	
			long endTime = System.currentTimeMillis();
			System.out.println("exercise7 : ");
			result.forEach(o -> System.out.println(o.toString()));
		}
	
		// "Calculate the total sum lump of all orders placed in Feb 2021")
		public void exercise8() {
			long startTime = System.currentTimeMillis();
			double result = orderRepo.findAll()
					.stream()
					.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
					.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
					.flatMap(o -> o.getProducts().stream())
					.mapToDouble(Prod::getPrice)
					.sum();
	
			long endTime = System.currentTimeMillis();
			System.out.println( "Total lump sum = " + result);
		}
	
		// "Calculate the total lump of all orders placed in Feb 2021 (using reduce with BiFunction)")
		public void exercise8a() {
			BiFunction<Double, Prod, Double> accumulator = (acc, product) -> acc + product.getPrice();
	
			long startTime = System.currentTimeMillis();
			double result = orderRepo.findAll()
					.stream()
					.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
					.filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
					.flatMap(o -> o.getProducts().stream())
					.reduce(0D, accumulator, Double::sum);
	
			long endTime = System.currentTimeMillis();
			System.out.println("Total lump sum = " + result);
		}
	
		// "Calculate the average price of all orders placed on 15-Mar-2021")
		public void exercise9() {
			long startTime = System.currentTimeMillis();
			double result = orderRepo.findAll()
					.stream()
					.filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
					.flatMap(o -> o.getProducts().stream())
					.mapToDouble(Prod::getPrice)
					.average().getAsDouble();
	
			long endTime = System.currentTimeMillis();
			System.out.println("Average = " + result);
		}
		
		public double exercise9ByRest() {
			long startTime = System.currentTimeMillis();
			double result = orderRepo.findAll()
					.stream()
					.filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
					.flatMap(o -> o.getProducts().stream())
					.mapToDouble(Prod::getPrice)
					.average().getAsDouble();
	
			long endTime = System.currentTimeMillis();
			System.out.println("Average = " + result);
			return result;
		}
	
		// "Obtain statistics summary of all products belong to \"Books\" category")
		public void exercise10() {
			long startTime = System.currentTimeMillis();
			DoubleSummaryStatistics statistics = productRepo.findAll()
					.stream()
					.filter(p -> p.getCategory().equalsIgnoreCase("Books"))
					.mapToDouble(Prod::getPrice)
					.summaryStatistics();
	
			long endTime = System.currentTimeMillis();
			System.out.println("exercise10 : "+String.format("count = %1$d, average = %2$f, max = %3$f, min = %4$f, sum = %5$f",
					statistics.getCount(), statistics.getAverage(), statistics.getMax(), statistics.getMin(), statistics.getSum()));
	
		}
	
		// ("Obtain a mapping of order id and the order's product count")
		public void exercise11() {
			long startTime = System.currentTimeMillis();
			Map<Long, Integer>  result = orderRepo.findAll()
					.stream()
					.collect(
							Collectors.toMap(
									Order::getId,
									order -> order.getProducts().size())
							);
	
			long endTime = System.currentTimeMillis();
			System.out.println("exercise11 : "+result.toString());
		}
	
		//"Obtain a data map of customer and list of orders")
		public void exercise12() {
			long startTime = System.currentTimeMillis();
			Map<Customer, List<Order>> result = orderRepo.findAll()
					.stream()
					.collect(Collectors.groupingBy(Order::getCustomer));
	
			long endTime = System.currentTimeMillis();
			System.out.println("exercise12 : "+result.toString());
		}
		
		public String exercise12rest() throws JsonProcessingException {
			long startTime = System.currentTimeMillis();
			Map<Customer, List<Order>> result = orderRepo.findAll()
					.stream()
					.collect(Collectors.groupingBy(Order::getCustomer));
			
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
	
			long endTime = System.currentTimeMillis();
			System.out.println("exercise12 : "+result.toString());
			 String arrayToJson = mapper.writeValueAsString(result);
			 System.out.println("exercise12 : "+arrayToJson);
			return arrayToJson;
		}
		
		public String exercise12restString() {
			long startTime = System.currentTimeMillis();
			Map<Customer, List<Order>> result = orderRepo.findAll()
					.stream()
					.collect(Collectors.groupingBy(Order::getCustomer));
	
			long endTime = System.currentTimeMillis();
			System.out.println("exercise12 : "+result.toString());
			return result.toString();
		}
	
		// "Obtain a data map of customer_id and list of order_id(s)")
		public void exercise12a() {
			long startTime = System.currentTimeMillis();
			HashMap<Long, List<Long>> result = orderRepo.findAll()
					.stream()
					.collect(
							Collectors.groupingBy(
									order -> order.getCustomer().getId(),
									HashMap::new,
									Collectors.mapping(Order::getId, Collectors.toList())));
			long endTime = System.currentTimeMillis();
			System.out.println("exercise12a : "+result.toString());
		}

		 // "Obtain a data map with order and its total price")
		public void exercise13() {
			long startTime = System.currentTimeMillis();
			Map<Order, Double> result = orderRepo.findAll()
					.stream()
					.collect(
						Collectors.toMap(
								Function.identity(),
								order -> order.getProducts().stream()
											.mapToDouble(Prod::getPrice).sum())
						);
	
			long endTime = System.currentTimeMillis();
			System.out.println("exercise13 : "+result.toString());
		}
	
		 // ("Obtain a data map with order and its total price (using reduce)")
		public void exercise13a() {
			long startTime = System.currentTimeMillis();
			Map<Long, Double> result = orderRepo.findAll()
					.stream()
					.collect(
							Collectors.toMap(
									Order::getId,
									order -> order.getProducts().stream()
											.reduce(0D, (acc, product) -> acc + product.getPrice(), Double::sum)
							));
	
			long endTime = System.currentTimeMillis();
			System.out.println("exercise13a : "+result.toString());
		}
	
		 // ("Obtain a data map of product name by category")
		public void exercise14() {
			long startTime = System.currentTimeMillis();	
			Map<String, List<String>> result = productRepo.findAll()
					.stream()
					.collect(
							Collectors.groupingBy(
									Prod::getCategory,
									Collectors.mapping(Prod::getName, Collectors.toList()))
							);
	
	
			long endTime = System.currentTimeMillis();
			System.out.println("exercise14 : "+result.toString());
		}
	
		 // "Get the most expensive product per category")
		public void exercise15() {
			long startTime = System.currentTimeMillis();
			Map<String, Optional<Prod>> result = productRepo.findAll()
					.stream()
					.collect(
							Collectors.groupingBy(
									Prod::getCategory,
									Collectors.maxBy(Comparator.comparing(Prod::getPrice)))
							);
			long endTime = System.currentTimeMillis();
			System.out.println("exercise15 : "+result.toString());
			result.forEach((k,v) -> {
				System.out.println("key=" + k + ", value=" + v.get());
			});
	
		}
		
		 // ("Get the most expensive product (by name) per category")
		public void exercise15a() {
			long startTime = System.currentTimeMillis();
			Map<String, String> result = productRepo.findAll()
					.stream()
					.collect(
							Collectors.groupingBy(
									Prod::getCategory,
									Collectors.collectingAndThen(
											Collectors.maxBy(Comparator.comparingDouble(Prod::getPrice)),
											optionalProduct -> optionalProduct.map(Prod::getName).orElse(null)
									)
							));
			long endTime = System.currentTimeMillis();
			System.out.println("exercise15a : "+result.toString());
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

