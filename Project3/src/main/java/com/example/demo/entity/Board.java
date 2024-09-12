package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
// 엔티티의 변화를 감지하는 리스너 설정
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tbl_board")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

	@Id
	// PK고 자료명이 숫자일때 AUTO_INCREMENT쓰기
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int boardNo;
	
	@Column(length = 30, nullable = false)
	String title;
	
	// 숫자, 논리는 생략 OK. 텍스트는 length 크기 정해줘야함(종류에 따라 크기가 달라지기에..)
	@Column(length = 200) // nullable의 기보낙ㅄ은 true
	String content;
	
	// 인스턴스가 생성되는 것을 감지하여 현재시간을 저장
	// insert 한번
	@CreatedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime createDate; // 최초등록일
	
	// 인스턴스가 생성 또는 수정되는 것을 감지하여 현재시간을 저장
	// insert 될 때, update 될 때
	@LastModifiedDate
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime modifiedDate; // 최종수정일
	
}
