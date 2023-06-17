package com.tradebulls.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tradebulls.entity.Order;

@Repository
public interface OrderRepo extends CrudRepository<Order, Long> {

	List<Order> findAll();
	
	@Query(value = "SELECT * FROM USER u inner join PRODUCT p on u.id = p.id WHERE p.catagpry = game AND u.status = pending", nativeQuery = true)
	List<Order> findProducts();
}
