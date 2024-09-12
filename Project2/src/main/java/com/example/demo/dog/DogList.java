package com.example.demo.dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DogList {

	@Autowired
	Dog dog;
	
	public Dog getDog() {
		return dog;
	}
	
}
