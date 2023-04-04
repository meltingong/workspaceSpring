package com.itwill.ilhajob.awards;

import java.util.Date;

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
public class Awards {
	private int awardsSeq;
	private String awardsName;
	private Date awardsDate;
	private String awardsContent;
	private int userSeq;


}
