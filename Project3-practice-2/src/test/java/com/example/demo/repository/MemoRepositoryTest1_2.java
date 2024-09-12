package com.example.demo.repository;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest1_2 {

	@Autowired
	MemoRepository repository;
	
	@Test
	void 메모데이터100개등록() {
		
		IntStream.rangeClosed(1, 100).forEach(value -> {
			
			Memo memo = Memo
					.builder()
					.text("Sample.." + value)
					.build();
			
			repository.save(memo);
			
		});
		
	}
	
	@Test
	void 페이징처리() {
		
		Pageable pageable = PageRequest.of(0, 10);
		
		Page<Memo> page = repository.findAll(pageable);
		
		List<Memo> list = page.getContent();
		
		System.out.println(list);
		 
		System.out.println("총 페이지: " + page.getTotalPages());
		System.out.println("현재 페이지 번호: " + page.getNumber());
		System.out.println("페이지당 데이터 개수: " + page.getSize());
		System.out.println("다음 페이지 존재 여부: " + page.hasNext());
		System.out.println("시작 페이지 여부: " + page.isFirst());
		
	}
	
	@Test
	void 정렬조건추가하기() {
		Sort sort = Sort
					.by("no")
					.descending();
		
		Pageable pageable = PageRequest.of(0, 10, sort);

		Page<Memo> page = repository.findAll(pageable);
		
		List<Memo> list = page.getContent();
		
		for(Memo memo : list) {
			System.out.println(memo);
		}
					
	}
	
}
