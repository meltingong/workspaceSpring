package com.itwill.ilhajob.corp.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecruitDto {
	/*
	이름               널?       유형            
	---------------- -------- ------------- 
	RC_SEQ           NOT NULL NUMBER(20)    
	RC_TITLE                  VARCHAR2(100) 
	RC_POSITION               VARCHAR2(30)  
	RC_CONTENT                VARCHAR2(200) 
	RC_QUALIFICATION          VARCHAR2(50)  
	RC_SALARY                 NUMBER(20)    
	RC_DEADLINE               DATE          
	RC_READ_COUNT             NUMBER(10)    
	CORP_ID          NOT NULL VARCHAR2(30)  
	*/
	
	private int rcSeq;
	private String rcTitle; 
	private String rcPosition;
	private String rcContent;
	private String rcQualification;
	private int rcSalary;
	private Date rcDate;
	private Date rcDeadline;
	private int rcReadCount;
	private String corpId;
	@ToString.Exclude
	private CorpDto corp;
	
}
