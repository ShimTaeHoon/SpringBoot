package com.example.demo.optional;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// 준비
@SpringBootTest
public class OptionalTest {

	// Optional 클래스는 null값을 안전하게 처리하기 위한 클래스
	// 값의 존재여부에 따라 로직을 처리할 것
	
	// 준비
	@Test
	void Optional사용하기() {
		
		String str = "apple";
		// of함수: 값을 입력받아서 객체를 생성하는 함수(생성자 역할, new대신)
		//       <제네릭>                 객체생성
		Optional<String> opt = Optional.of(str);
		
//		System.out.println("Optional에서 값 꺼내기: " + opt.get());
//													//객체가 비어있는지 확인
//		System.out.println("Optional 안에 값이 없는지?: " + opt.isEmpty());
//		//                             //optional객체가 값을 가지고 있는지 확인
//		System.out.println("Optional 안에 값이 있는지?: " + opt.isPresent());
		
		// of는 null시 오류
		// ofNullable함수는 of함수와 달리 빈값도 저장할 수 있음!
		String str2 = "apple";
		Optional<String> opt2 = Optional.ofNullable(str2);
		
		// (orElse) 값이 있으면 그대로 사용, 값이 없으면 "바나나"로 대체
		// 조건문 함수
//		System.out.println(opt2.orElse("banana"));
	}
	
	@Test
	void of와ofNullable의차이() {

		//of: Optional을 생성하는 함수. null 입력 불가
		//ofNullable: Optional을 생성하는 함수. null 입력 가능
		
		String str = null;
//		Optional<String> opt1 = Optional.of(str); //에러남.
		Optional<String> opt2 = Optional.ofNullable(str);
	}
	
	@Test
	void 빈객체를사용하는경우() {
		
		// Optional 객체를 생성하고 빈값을 저장
		Optional<String> opt = Optional.ofNullable("banana");
		
		// 객체 안에 있는 값 꺼내기
//		System.out.println(opt.get()); // 에러남.
		
		// 조건문을 사용하여 null값 체크하기
		if(opt.isPresent() == true) {
			System.out.println(opt.get());
		} else {
			System.out.println("값이 없습니다.");
		}
		
		// ifPresent함수를 사용하여 빈값 체크하기
		// 함수형 인터페이스가 나오면 람다식 함수로 구현한다
		opt.ifPresent(t-> System.out.println(t + "값이 존재합니다."));
		
		}
	
}

// t: value
//void accept(T t) {
//	
//	System.out.println(t + "값이 존재합니다.");
//	
//}
