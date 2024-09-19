package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Gift;

public interface GiftRepository extends JpaRepository<Gift, Integer>{

	@Query(value = "SELECT * FROM TBL_GIFT WHERE PRICE >= :price", nativeQuery = true)
	List<Gift> get1(@Param("price") int price); 
	
	@Query(value = "SELECT * FROM TBL_GIFT TG WHERE NAME LIKE %:name", nativeQuery = true)
	List<Gift> get2(@Param("name") String name);
	
	@Query(value = "SELECT * FROM TBL_GIFT TG WHERE PRICE <= :price AND `type` = :type", nativeQuery = true)
	List<Gift> get3(@Param("price") int price, @Param("type") String type);
	
}
