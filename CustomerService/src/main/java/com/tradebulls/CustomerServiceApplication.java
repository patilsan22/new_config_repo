package com.tradebulls;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomerServiceApplication{
	
	static Logger log = Logger.getLogger(CustomerServiceApplication.class);

	public static void main(String[] args) throws Exception {
		
		SpringApplication.run(CustomerServiceApplication.class, args);
		System.out.println("SYSTEM ON..");
		
        for(int i = 0; i < 10; i++) {
        	System.out.println(" ....");
        	log.info("This is the " + i + " time I say 'Customer service started..........'.");
        }
		
	}

}
