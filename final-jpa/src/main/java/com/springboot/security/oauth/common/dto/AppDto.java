package com.springboot.security.oauth.common.dto;


import java.time.LocalDateTime;
import java.util.List;

import com.springboot.security.oauth.corp.dto.RecruitDto;
import com.springboot.security.oauth.user.dto.CvDto;
import com.springboot.security.oauth.user.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AppDto {
	
	private long id;
	private int appStatus;
	private LocalDateTime appCreateDate;
	
	private RecruitDto recruit;
	//@ToString.Exclude
	private CvDto cv;
	@ToString.Exclude
	private UserDto user;
}
