package com.itwill.jpa.entity;


import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor  // null이 아닌 것들에 대해 생성자 생성

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="id")
	private Long userId;
	
	@NonNull
	@Column(nullable = false)
	private String name;
	
	private String email;
	@ColumnDefault("sysdate")
	private Date createdAt;
	
	@ColumnDefault("sysdate")
	private LocalDateTime updatedAt;
}
