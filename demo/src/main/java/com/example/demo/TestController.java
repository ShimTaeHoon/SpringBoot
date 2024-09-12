package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	// 주소를 맵핑하고(/hello) 웹사이트 실행하면 안녕하세요라는 문자열 반환
	@GetMapping("/hello")
	public String hello() {
		return "안녕하세요";
	}
	
}
