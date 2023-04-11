package com.itwill.ilhajob.user.dto;

import com.itwill.ilhajob.corp.dto.CorpDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReviewDto {
	private Long id;
	private int reviewGrade;
	private String reviewTitle;
	private String reviewContent;
	@ToString.Exclude
	private CorpDto corp;
	@ToString.Exclude
	private UserDto user;
	
}
