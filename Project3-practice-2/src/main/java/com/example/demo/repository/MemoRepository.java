package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

@Transactional
public interface MemoRepository extends JpaRepository<Memo, Integer> {

	List<Memo> findByNoBetween(int from, int to);
	
	List<Memo> findByNoLessThan(int mno);
	
}
