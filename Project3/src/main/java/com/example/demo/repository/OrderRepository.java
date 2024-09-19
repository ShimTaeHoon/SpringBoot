package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query(value = "SELECT * FROM TBL_ORDER WHERE SHIP_ADDRESS LIKE %:address%", nativeQuery = true)
	List<Order> get1(@Param("address") String address);
	
	@Query(value = "SELECT * FROM TBL_ORDER WHERE ORDER_DATE = :orderdate", nativeQuery = true)
	List<Order> get2(@Param("orderdate") LocalDate orderdate);
	
}
