package com.itwill.ilhajob.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EduDto {
	/*
	이름             널?       유형
	-------------- -------- ------------
	EDU_SEQ        NOT NULL NUMBER(20)
	EDU_MAJOR      NOT NULL VARCHAR2(20)
	EDU_NAME       NOT NULL VARCHAR2(50)
	EDU_START_DATE NOT NULL DATE
	EDU_END_DATE            DATE
	EDU_SCORE               VARCHAR2(10)
	EDU_CONTENT             VARCHAR2(50)
	USER_SEQ                NUMBER(20)
	 */

	private int eduSeq;
	private String eduMajor;
	private String eduName;
	private Date eduStartDate;
	private Date eduEndDate;
	private String eduScore;
	private String eduContent;
	private int userSeq;
}
