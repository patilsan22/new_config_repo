package com.tradebulls.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tradebulls.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	@Query(value = "select * from employee_details where emp_id = :id", nativeQuery = true)
	Optional<Employee> findById(String id);
	
	@Query(value = "select * from employee_details where emp_name = :name", nativeQuery = true)
	Optional<Employee> findByName(String name);

}
