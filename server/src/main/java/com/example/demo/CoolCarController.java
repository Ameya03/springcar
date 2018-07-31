package com.example.demo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoolCarController {

	private CarRepository repository;
	
	public CoolCarController(CarRepository repository) {
		this.repository=repository;
	} 
	
	@GetMapping("/cool")
	public List<Car> coolcars(){
	return repository.findAll().stream().filter(this::isCool).collect(Collectors.toList());
	}
	
	public boolean isCool(Car car) {
		
		return !car.getName().equals("Ford Pinto");
		
		
	}
	
}
