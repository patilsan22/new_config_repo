package com.tradebulls.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tradebulls.entity.CustomerDetails;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDetails, Integer>{
	
	@Query(value = "select * from customer_info where cust_id = :id", nativeQuery = true)
	Optional<CustomerDetails> findById(String id);

	@Query(value = "delete * from customer_info where cust_id = :id", nativeQuery = true)
	void deleteById(String id);

}
