package com.tradebulls.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tradebulls.entity.BankDetails;
@Repository
public interface BankRepository extends JpaRepository<BankDetails, Integer>{
	
}
