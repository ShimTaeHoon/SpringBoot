package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Memo;

@SpringBootTest
public class MemoRepositoryTest {

	@Autowired
	MemoRepository memoRepository;
	
	@Test
	public void 리파지토리객체를_가져왔는지화인() {
		System.out.println("memoRepository = " + memoRepository);
	}
	
	@Test
	public void 데이터단건등록() {
		Memo memo = Memo
						.builder()
						.test("ㅎㅇ")
						.build();
	
		Memo memo2 = Memo
						.builder()
						.text("ㅋㅋ")
						.test("ㅎㅎ")
						.build();
	memoRepository.save(memo);
	memoRepository.save(memo2);
	
	}
	
	@Test
	public void 데이터일괄등록() {
		
		List<Memo> list = new ArrayList<>();
		
		Memo memo3 = Memo
						.builder()
						.test("ㄱㄱ")
						.build();
		Memo memo4 = Memo
						.builder()
						.test("ㄹㄹ")
						.build();
		
		list.add(memo3);
		list.add(memo4);
		
		memoRepository.saveAll(list);
		
	}
	
	@Test
	public void 데이터단건조회() {
		Optional<Memo> optional = memoRepository.findById(1);
		
		System.out.println(optional.get());
		
	}
	
	@Test
	public void 데이터수정() {
		Memo memo = Memo
				.builder()
				.no(3)
				.test("오호")
				.build();
		
		memoRepository.save(memo);
	}
	
	@Test
	public void 데이터삭제() {
		memoRepository.deleteById(1);
	}
	
	@Test
	public void 데이터전체삭제() {
		memoRepository.deleteAll();
	}
	
}
