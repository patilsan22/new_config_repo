package com.tradebulls.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tradebulls.entity.AddressDetails;
import com.tradebulls.entity.CustomerDetails;
@Repository
public interface AddressRepository extends JpaRepository<AddressDetails, Integer> {
	
	@Query(value = "select * from address_info where cust_id = :cust_id", nativeQuery = true)
	Optional<AddressDetails> findById(String cust_id);

}
