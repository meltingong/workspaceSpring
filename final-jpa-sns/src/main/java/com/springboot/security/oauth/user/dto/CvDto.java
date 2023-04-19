package com.springboot.security.oauth.user.dto;

import java.util.List;

import org.springframework.lang.Nullable;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CvDto {
	private Long id;
	private String cvName;
	private String cvDescription;
	private String cvPortfolio;
	@ToString.Exclude
	private UserDto user;
}
