package com.itwill.ilhajob.corp.dto;

import java.time.LocalDateTime;
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
	
	private Long id;
	private String rcTitle; 
	private String rcPosition;
	private String rcContent;
	private String rcQualification;
	private Integer rcSalary;
	private LocalDateTime rcDate;
	private LocalDateTime rcDeadline;
	private Integer rcStatus;
	private Integer rcAppCount;
	private Integer rcReadCount;
	//@ToString.Exclude
	private CorpDto corp;
	
}
