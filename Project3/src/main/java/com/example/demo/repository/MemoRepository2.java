package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Memo;

import jakarta.transaction.Transactional;

// 이 부분이 있어야 update, delete, commit 처리 됨
@Transactional

public interface MemoRepository2 extends JpaRepository<Memo, Integer> {

	// jpql 사용하기
	// 테이블 대신 엔티티 사용
	// 컬럼 대신 엔티티의 필드 사용
	
	// 메모의 번호가 3보다 작은 데이터 검색

	// select * from tbl_memo where no < ? 
	@Query("select m from Memo m where m.no < :mno")
	List<Memo> get1(@Param("mno") int mno);
	
	// 메모의 내용이 없는 데이터 검색
	// select * from tbl_memo where order_no is null
//	@Query("select m from Memo m where m.orderNo is null")

	//	select * from tbl_memo where text is null
	@Query("select m from Memo m where m.text is null")
	List<Memo> get2();
	
	// 메모의 번호가 10에서 20 사이인 데이터 검색
	// select * from tbl_memo where no between ? and ?
	@Query("select m from Memo m where m.no between :p1 and :p2")
	List<Memo> get3(@Param("p1") int from, @Param("p2") int to);
	
	// 순수한 SQL 사용하기!
	// DB에서 확인하고 VALUE에 넣기
	@Query(value = "SELECT * FROM TBL_MEMO ORDER BY NO DESC", nativeQuery = true)
	// 반환을 List로
	List<Memo> get4();
	
	@Modifying
	@Query(value = "DELETE FROM TBL_MEMO WHERE NO = :param", nativeQuery = true)
	// 반환할 값이 없어서 void로
	void delete1(@Param("param") int mno);
	
	// 객체 파라미터
	@Modifying // 수정시 @Modifying 필요
	@Query(value = "UPDATE TBL_MEMO SET TEXT = :#{#param.text} WHERE NO = :#{#param.no}", nativeQuery = true)
	// 업데이트 성공시 0 실패시 1
	int update1(@Param("param") Memo memo);
	
}

