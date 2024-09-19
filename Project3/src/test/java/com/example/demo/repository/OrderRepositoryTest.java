package com.example.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Order;

@SpringBootTest
public class OrderRepositoryTest {

	@Autowired
	OrderRepository orderRepository;
	
	@Test
	public void oCheck() {
		
		System.out.println("order확인: " + orderRepository);
		
	}
	
	@Test
	public void oAdd() {
		
		List<Order> list = new ArrayList<>();
		
		LocalDate date = LocalDate.of(2023, 07, 01);
		LocalDate date2 = LocalDate.of(2023, 07, 02);
		LocalDate date3 = LocalDate.of(2023, 07, 03);
		LocalDate date4 = LocalDate.of(2023, 07, 01);
		LocalDate date5 = LocalDate.of(2023, 07, 02);
		
		Order order1  = Order
					.builder()
					.customer_name("둘리")
					.orderDate(date)
					.shipAddress("인천 구월동")
					.build();
		
		Order order2  = Order
				.builder()
				.customer_name("또치")
				.orderDate(date2)
				.shipAddress("인천 연수동")
				.build();
		
		Order order3  = Order
				.builder()
				.customer_name("도우너")
				.orderDate(date3)
				.shipAddress("부산 동래동")
				.build();
		
		Order order4  = Order
				.builder()
				.customer_name("마이콜")
				.orderDate(date4)
				.shipAddress(null)
				.build();
		
		Order order5  = Order
				.builder()
				.customer_name("고길동")
				.orderDate(date5)
				.shipAddress(null)
				.build();
		
		list.add(order1);
		list.add(order2);
		list.add(order3);
		list.add(order4);
		list.add(order5);
		
		orderRepository.saveAll(list);
		
	}
	
	@Test
	public void addressSearch() {
		List<Order> list = orderRepository.get1("인천");
		System.out.println(list);
	}
	
	@Test
	public void dateSearch() {
		LocalDate localDate = LocalDate.of(2024,9,11);
		List<Order> list = orderRepository.get2(localDate);
		System.out.println(list);
				
	}
	
	
}
