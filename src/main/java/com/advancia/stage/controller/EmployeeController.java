package com.advancia.stage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.advancia.stage.model.Employee;
import com.advancia.stage.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void create (@RequestBody Employee e) {
		employeeService.create(e);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Mono<Employee>> findById(@PathVariable("id") int id) {
		Mono<Employee> e = employeeService.findById(id);
		return new ResponseEntity<Mono<Employee>>(e, HttpStatus.OK) ;
	}
	
	@GetMapping("/name/{name}")
	public Flux<Employee> findByName (@PathVariable("name") String name) {
		return employeeService.findByName(name);
	}
	
	
	@GetMapping("/")
	public Flux<Employee> findAll(){
		Flux<Employee> emps = employeeService.findAll();
		return emps;
	}
	
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public Mono<Employee> update(@RequestBody Employee e) {
		return employeeService.update(e);
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		employeeService.delete(id).subscribe();
	}

}
