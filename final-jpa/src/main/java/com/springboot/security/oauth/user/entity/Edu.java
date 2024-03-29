package com.springboot.security.oauth.user.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(name = "edu_id_SEQ_gen", sequenceName = "edu_id_SEQ", allocationSize = 1)
@Table(name = "edu")
public class Edu {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edu_id_SEQ_gen")
	private Long id;

	@NonNull
	@Column(nullable = false)
	private String eduMajor;

	@NonNull
	@Column(nullable = false)
	private String eduName;

	@NonNull
	@Column(nullable = false)
	private LocalDateTime eduStartDate;

	@NonNull
	@Column(nullable = false)
	private LocalDateTime eduEndDate;

	private String eduScore;

	@Column(length = 1000)
	private String eduContent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@ToString.Exclude
	private User user;
}
