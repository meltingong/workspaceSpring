package com.itwill.ilhajob.user.dto;

import java.util.List;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CvDto {

	private int cvSeq;
	private String cvName;
	private String cvDescription;
	private String cvPortfolio;
	private int userSeq;
	private List<EduDto> eduList;
	private List<ExpDto> expList;
	private List<AwardsDto> awardsList;
	
	public CvDto(int cvSeq, String cvName, String cvDescription, String cvPortfolio, int userSeq) {
		this.cvSeq = cvSeq;
		this.cvName = cvName;
		this.cvDescription = cvDescription;
		this.cvPortfolio = cvPortfolio;
		this.userSeq = userSeq;
	}
	
	
	
}
