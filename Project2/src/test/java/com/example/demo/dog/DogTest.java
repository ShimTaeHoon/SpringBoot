package com.example.demo.dog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DogTest {

	@Autowired
	DogList doglist;
	
	@Autowired
	Dog dog;
	
	@Test
	void Sound() {
		System.out.println("왈왈!");
		System.out.println(dog);
		System.out.println(doglist.getDog());
	}
	
}
