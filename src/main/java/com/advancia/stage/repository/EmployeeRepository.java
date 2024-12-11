package com.advancia.stage.repository;


import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.advancia.stage.model.Employee;

import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Integer> {
	
	@Query("{'name': ?0")
	Flux<Employee> findByname(final String name);

}
