package com.itwill.ilhajob.common.dto;


import java.util.List;

import com.itwill.ilhajob.corp.dto.RecruitDto;
import com.itwill.ilhajob.user.dto.CvDto;

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
	
	private int app_seq;
	private char app_status;
	
	private RecruitDto rc;
	private CvDto cv;
	
	

}
