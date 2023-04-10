package com.itwill.ilhajob.review;

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
public class Review {
	private int reviewSeq;
	private String reviewGrade;
	private String reviewTitle;
	private String reviewContent;
	private String corpId;
	private int userSeq;
	
}
