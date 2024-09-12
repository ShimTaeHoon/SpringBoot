package com.example.demo.cat;

import org.springframework.stereotype.Component;

@Component
public class Cat {

	Cat cat;
	
	void eat() {
		System.out.println("쥐를 먹는다");
	}
}
