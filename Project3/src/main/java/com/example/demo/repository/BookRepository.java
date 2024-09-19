package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	// 1.SQL을 그대로 작성한다
	// 2.변경될 수 있는 값(파라미터)을 매개변수로 선언한다
	// 예를 들어 제목은 '자바~' 또는 '스프링~' 또는 '빈문자열'가 될 수 있다
	// 이런값들은 외부에서 입력받아 SQL에 동적으로 적용될 수 있도록 처리한다
	// 3.파라미터로 전달된 값을 SQL에 바인딩한다
	@Query(value = "", nativeQuery = true)
	List<Book> get123();
	
	// SELECT * FROM TBL_BOOK WHERE TITLE = 자바프로그래밍입문
	@Query(value = "SELECT * FROM TBL_BOOK WHERE TITLE = :title", nativeQuery = true)
	List<Book> get1(@Param("title") String title);

	@Query(value = "SELECT * FROM TBL_BOOK WHERE PRICE > :price AND publisher = :publisher", nativeQuery = true)
	List<Book> get2(@Param("price") int price, @Param("publisher") String publisher);
	
	@Query(value = "SELECT * FROM TBL_BOOK TB WHERE PUBLISHER = :publisher1 OR PUBLISHER = :publisher2", nativeQuery = true)
	List<Book> get3(@Param("publisher1") String publisher1, @Param("publisher2") String publisher2);

	
}
