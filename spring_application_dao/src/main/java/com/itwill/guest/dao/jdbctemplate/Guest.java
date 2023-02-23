package com.itwill.guest.dao.jdbctemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
이름             널?       유형             
-------------- -------- -------------- 
GUEST_NO       NOT NULL NUMBER(10)     
GUEST_NAME     NOT NULL VARCHAR2(50)   
GUEST_DATE     NOT NULL DATE           
GUEST_EMAIL             VARCHAR2(50)   
GUEST_HOMEPAGE          VARCHAR2(50)   
GUEST_TITLE    NOT NULL VARCHAR2(100)  
GUEST_CONTENT  NOT NULL VARCHAR2(4000) 
*/

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Guest {
	private int guest_no;
	private String guest_name;
	private String guest_date;
	private String guest_email;
	private String guest_homepage;
	private String guest_title;
	private String guest_content;
	


	
}
