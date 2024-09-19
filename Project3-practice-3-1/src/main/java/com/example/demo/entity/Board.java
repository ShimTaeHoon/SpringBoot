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

// 엔티티에 변화를 감지하는 리스너 설정(save, insert, update)
@EntityListeners(AuditingEntityListener.class)
@Entity // jpa에서 관리하는 엔티티 표시
@Table(name = "tbl_board") // 테이블 이름 생략 가능(안쓰면 entity이름이 테이블이 됨)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

	// PK는필수임. 없으면 ERROR남
	@Id //PK + AUTO INCREMENT
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int boardNo; //게시물 번호
	
	// 컬럼의 정보 설정 (크기, NOTNULL 옵션)
	@Column(length = 30, nullable = false) // NULL X
	String title;
	
	@Column(length = 200) // NULL OK / (nullable = true)
	String content;
	
	@CreatedDate //INSERT 시 실행
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime createDate; // 최초등록일(데이터 등록(insert) 될 때 딱 한번만 실행, 변경될 일 없음)
	
	@LastModifiedDate //INSERT 및 UPDATE 시 실행
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	LocalDateTime modifiedDate; // 최종수정일(insert할때도 실행, 업데이트할때마다 교체, 여러번)
	
}
