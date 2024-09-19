package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{

	@Query(value = "SELECT * FROM TBL_MEMBER WHERE USER_ID LIKE %:user%", nativeQuery = true)
	List<Member> get1(@Param("user") String user); 
	
	@Query(value = "SELECT * FROM TBL_MEMBER WHERE GRADE = :grade", nativeQuery = true)
	List<Member> get2(@Param("grade") String grade);
	
}
