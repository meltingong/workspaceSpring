package com.itwill.ilhajob.corp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
		manager_email                 		VARCHAR2(40)		 NOT NULL,
		manager_name                  		VARCHAR2(20)		 NULL ,
		manager_position              		VARCHAR2(30)		 NOT NULL,
		manager_phone                 		VARCHAR2(20)		 NOT NULL,
		corp_id                       		VARCHAR2(30)		 NOT NULL
);
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerDto {
	String managerEmail;
	String managerName;
	String managerPosition;
	String managerPhone;
	String corpId;
	
	
	//Manager 이메일/이름 일치하는지 확인해야함? user password 확인처럼?
}
