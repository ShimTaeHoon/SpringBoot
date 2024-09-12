package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {

	@Autowired
	MemberRepository memberRepository;
	
	@Test
	public void mCheck() {
		System.out.println("member확인 : " + memberRepository);
	}
	
	@Test
	public void mAdd() {
		List<Member> list = new ArrayList<>();
		
		Member member1 = Member
					.builder()
					.user_id("admin")
					.grade("관리자")
					.password("1234")
					.build();
		
		Member member2 = Member
				.builder()
				.user_id("user1")
				.grade("사용자")
				.password("1234")
				.build();
		
		Member member3 = Member
				.builder()
				.user_id("user2")
				.grade("사용자")
				.password("1234")
				.build();
		
		Member member4 = Member
				.builder()
				.user_id("yoyt22")
				.grade("관리자")
				.password("1234")
				.build();
		
		list.add(member1);
		list.add(member2);
		list.add(member3);
		list.add(member4);
		
		memberRepository.saveAll(list);
		
	}
	
	@Test
	public void mRead() {
		
		Optional<Member> optional = memberRepository.findById("user2");
		
		if(optional.isPresent()) {
			System.out.println(optional.get());
		} else {
			System.out.println("땡");
		}
		
	}
	
	@Test
	public void mReadAll() {
		
		List<Member> list = memberRepository.findAll();
		
		for(Member member : list) {
			System.out.println(member);
		}
		
	}
	
	@Test
	public void mModify() {
		Optional<Member> result = memberRepository.findById("admin");
		Member member = result.get();
		member.setPassword("asd123");
		
		memberRepository.save(member);
		
	}
	
	@Test
	public void mDelete() {
		memberRepository.deleteById("user1");
	}
	
}
