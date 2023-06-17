package com.tradebulls.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tradebulls.entity.Prod;

@Repository
public interface ProductsRepo extends CrudRepository<Prod, Long> {

	List<Prod> findAll();
}
