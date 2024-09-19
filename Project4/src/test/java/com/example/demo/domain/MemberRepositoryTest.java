package com.example.demo.domain;

import java.util.List;

import org.junit.jupiter.api.Test;

public class MemberRepositoryTest {

	// 스프링을 사용하지 않았기 때문에 직접 리파지토리 객체 생성해야함
	MemberRepository repository = new MemberRepository();

	@Test
	public void 테스트() {
		
		// 1. 회원 등록 (2명)
		Member member1 = new Member(0, "insuKim", "1234");
		repository.save(member1);
		
		Member member2 = new Member(0, "joohwanBae", "5678");
		repository.save(member2);
		// 2. 회원 목록 조회
		List<Member> list = repository.findAll();
		System.out.println(list);
		// 3. 1번째 회원 조회
		Member member = repository.finalById(1);
		System.out.println(member);
		// 4. 모든 회원 삭제
		repository.clearStore();
	}
	
}
