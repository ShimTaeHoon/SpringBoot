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

		// rangeClosed: 1~100 범위의 100개 크기의 스트림 생성
		// forEach : 특정 작업을 수행하는 함수
		IntStream.rangeClosed(1, 100).forEach(value -> {

			Memo memo = Memo.builder().text("Sample.." + value).build();

			repository.save(memo);

		});

	}
	
	@Test
	void 페이징처리() {
		
		// Pageable: 페이지 번호, 데이터 개수를 담아서 조건을 생성
		// of: Pageable 객체를 생성하는 함수
										//번호 //개수
		Pageable pageable = PageRequest.of(0, 10);
		//인터페이스          //클래스
		
		// 변수를 쓸때는 메소드 선언부 참고!
		// domain.page로 import해야함
		Page<Memo> page = repository.findAll(pageable);
		
//		List<Memo> page2 = repository.findAll();
		
		// 결과에서 실제 데이터 꺼내기
		List<Memo> list = page.getContent();
		
		System.out.println(list);
		
		// 페이징 처리를 하면 sql에 limit이 추가된다
		// 이때 SQL의 LIMIT절은 "LIMIT 0,10"이 된다
		// 만약 두 번째 페이지를 조회한다면 LIMIT절은 "LIMIT 10, 10"이 된다 (시작인덱스(레코드번호), 개수)
	
		// 페이지 부가 정보
		System.out.println("총 페이지:" + page.getTotalPages());
		System.out.println("현재 페이지 번호:" + page.getNumber());
		System.out.println("페이지당 데이터 개수:" + page.getSize());
		System.out.println("다음 페이지 존재 여부:" + page.hasNext());
		System.out.println("시작 페이지 여부:" + page.isFirst());
		
	}
	
	@Test
	void 정렬조건추가하기() {
		
		// no 필드를 기준으로 역정렬하는 조건을 생성
		// ★임포트는 맨끝에 있는 domain★
		Sort sort = Sort
					.by("no") // 기준
					.descending(); // 정렬방식
		
		// 페이징 조건에 정렬 방식 추가 (.of로 확인해보기 ctrl + space)
		Pageable pageable = PageRequest.of(0, 10, sort);
		
		// 페이지 조건을 전달하여 데이터 조회
		Page<Memo> page = repository.findAll(pageable);
		
		// 결과에서 실제 데이터만 꺼내기
		List<Memo> list = page.getContent();
		
		// 반환 받은 데이터를 프린트하기
		for (Memo memo : list) {
			System.out.println(memo);
		}
		
		// 정렬 조건을 추가하여 sql에 order by절이 추가됨
		
		
	}

}
