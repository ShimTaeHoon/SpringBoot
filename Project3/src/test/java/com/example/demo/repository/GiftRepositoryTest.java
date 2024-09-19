package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Gift;

@SpringBootTest
public class GiftRepositoryTest {

	@Autowired
	GiftRepository giftRepository;
	
	@Test
	public void gCheck() {
		System.out.println("gift확인: " + giftRepository);
	}
	
	@Test
	public void gAdd() {
		List<Gift> list = new ArrayList<>();
		
		Gift gift1 = Gift
				.builder()
				.name("참치세트")
				.price(10000)
				.type("식품")
				.build();
		
		Gift gift2 = Gift
				.builder()
				.name("햄세트")
				.price(20000)
				.type("식품")
				.build();
		
		Gift gift3 = Gift
				.builder()
				.name("샴푸세트")
				.price(30000)
				.type("생활용품")
				.build();
		
		Gift gift4 = Gift
				.builder()
				.name("세차용품")
				.price(40000)
				.type("생활용품")
				.build();
		
		Gift gift5 = Gift
				.builder()
				.name("주방용품")
				.price(50000)
				.type("생활용품")
				.build();
		
		Gift gift6 = Gift
				.builder()
				.name("노트북")
				.price(60000)
				.type("가전제품")
				.build();
		
		Gift gift7 = Gift
				.builder()
				.name("벽걸이TV")
				.price(10000)
				.type("가전제품")
				.build();
		
		list.add(gift1);
		list.add(gift2);
		list.add(gift3);
		list.add(gift4);
		list.add(gift5);
		list.add(gift6);
		list.add(gift7);
		
		giftRepository.saveAll(list);
		
	}
	
	@Test
	public void gRead() {
		
		Optional<Gift> optional = giftRepository.findById(1);
		
		if(optional.isPresent()) {
			System.out.println(optional.get());
		} else {
			System.out.println("ㅗ");
		}
		
	}
	
	@Test
	public void gReadAll() {
		List<Gift> list = giftRepository.findAll();
		
		for(Gift gift : list) {
			System.out.println(gift);
		}
	}
	
	@Test
	public void gModify() {
		Optional<Gift> result = giftRepository.findById(2);
		Gift gift = result.get();
		gift.setName("내용수정1234567");
		
		giftRepository.save(gift);
	}
	
	@Test
	public void gDelete() {
		giftRepository.deleteById(2);
	}
	
	@Test
	public void giftPriceSearch() {
		List<Gift> list = giftRepository.get1(50000);
		System.out.println(list);
	}
	
	@Test
	public void setSearch() {
		List<Gift> list = giftRepository.get2("세트");
		System.out.println(list);
		
	}
	
	@Test
	public void typeSearch() {
		List<Gift> list = giftRepository.get3(40000, "생활용품");
		System.out.println(list);
	}
	
}
