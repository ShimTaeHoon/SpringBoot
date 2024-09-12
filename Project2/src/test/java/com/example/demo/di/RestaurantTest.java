package com.example.demo.di;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// 아래 어노테이션 생략하면 JUnit안됨
@SpringBootTest
public class RestaurantTest {

//	Restaurant restaurant = new Restaurant();
	@Autowired
	Restaurant restaurant;
	
	// 싱글톤 패턴?
//	Chef chef = new 이연복();
	// Autowired를 통해 객체(이연복)를 주입받음
	@Autowired
	Chef chef;
	
	@Test
	void 테스트() {
		System.out.println("restaurant: " + restaurant);
		System.out.println("chef: " + chef); // 의존성 주입하면 주소값 똑같음 
		System.out.println("getChef(): " + restaurant.getChef()); // 의존성 주입하면 주소값 똑같음 
	}
	
}
