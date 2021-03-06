package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

import java.util.stream.Stream;

import org.springframework.*;

@SpringBootApplication
public class ListdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListdemoApplication.class, args);
	}

@Bean
ApplicationRunner init(CarRepository repository) {
return args -> {
	Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
            "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(
			name ->{
				Car car = new Car();
				car.setName(name);
				repository.save(car);
				
			});
	    repository.findAll().forEach(name->{System.out.println(name.getId()+"   "+name.getName());});

};	
}

}
