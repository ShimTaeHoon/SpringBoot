package com.example.demo.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString // 없으면 객체의 주소값 출력됨
@NoArgsConstructor //디폴트생성자
@AllArgsConstructor //생성자(모든매개변수)
@Builder //생성자
public class Person {

	String name;
	int age;
	
}
