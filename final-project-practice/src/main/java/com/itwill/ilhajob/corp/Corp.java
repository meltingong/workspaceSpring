package com.itwill.ilhajob.corp;


import java.util.Date;
import java.util.List;

import com.itwill.ilhajob.blog.Blog;
import com.itwill.ilhajob.corpimage.CorpImage;
import com.itwill.ilhajob.manager.Manager;
import com.itwill.ilhajob.order.Orders;
import com.itwill.ilhajob.recruit.Recruit;
import com.itwill.ilhajob.review.Review;

import java.util.Date;

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
public class Corp {
	private String corpId;
	private String corpPassword;
	private String corpName;
	private String corpPhone;
	private String corpBusinessNo;
	private String corpWebsite;
	private Date corpEst;
	private String corpSize;
	private String corpSales;
	private String corpComment;
	private String corpWelfare;
	private String corpAddress;
	private char corpStatus;
	private String job;
	private int role;
	
	private Orders orders;
	private List<Recruit> recruitList;
	private List<Review> reviewList;
	private List<CorpImage> corpImageList;
	private List<Manager> managerList;
	
	/*
	 *패쓰워드 일치여부 검사 
	 */
	public boolean isMatchPassword(String corpPassword){
		boolean isMatch=false;
		if(this.corpPassword.equals(corpPassword)){
			isMatch=true;
		}
		return isMatch;
	}
}
/*
	이름               널?       유형             
---------------- -------- -------------- 
CORP_ID          NOT NULL VARCHAR2(30)   
CORP_PASSWORD    NOT NULL VARCHAR2(45)   
CORP_NAME        NOT NULL VARCHAR2(50)   
CORP_PHONE                VARCHAR2(20)   
CORP_BUSINESS_NO          VARCHAR2(20)   
CORP_WEBSITE              VARCHAR2(50)   
CORP_EST                  DATE           
CORP_SIZE                 VARCHAR2(20)   
CORP_SALES                VARCHAR2(20)   
CORP_COMMENT              VARCHAR2(1000) 
CORP_WELFARE              VARCHAR2(50)   
CORP_ADDRESS              VARCHAR2(100)  
CORP_STATUS               CHAR(1)        
JOB_ID                    NUMBER(10)     
ROLE_ID                   NUMBER(20)   
*/

	

