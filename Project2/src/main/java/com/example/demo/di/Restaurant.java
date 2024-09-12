package com.example.demo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {

	// 직접 필요한 객체를 생성하는 방식
//	Chef chef = new 이연복();
	
	// 필요한 객체를 주입받는 방식
	// Autowired : 객체가 필요하다, 컨테이너가 필요한곳에 넣어줌
	@Autowired
	Chef chef;
	
	public Chef getChef() {
		return chef;
	}
	
}
