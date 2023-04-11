package com.itwill.ilhajob.recruit;

import java.util.Date;
import java.util.List;

import com.itwill.ilhajob.awards.Awards;
import com.itwill.ilhajob.corp.Corp;
import com.itwill.ilhajob.cv.Cv;
import com.itwill.ilhajob.edu.Edu;
import com.itwill.ilhajob.exp.Exp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Data
@NoArgsConstructor
//@AllArgsConstructor
@ToString
public class Recruit {
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
	private Corp corp;
}
