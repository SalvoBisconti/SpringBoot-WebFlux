package com.advancia.stage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advancia.stage.model.Employee;
import com.advancia.stage.repository.EmployeeRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public void create(Employee e) {
		 repo.save(e).subscribe();
	};
	
	@Override
	 public Mono<Employee> findById(Integer id) {
		return repo.findById(id);
	};
	
	  @Override
	public Flux<Employee> findByName(String name) {
		  return repo.findByname(name);
	  };
	  
	  @Override
	public Flux<Employee> findAll() {
		  return repo.findAll();
	  };
	 
	  @Override
	public Mono<Employee> update(Employee e) {
		  return repo.save(e);
	  };
	 
	  @Override
	public Mono<Void> delete(Integer id) {
		  return repo.deleteById(id);
	  };
	
	

}
