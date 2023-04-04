package com.itwill.ilhajob.admin;

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
public class Admin {
	
	private String adminId;
	private int blogSeq;
	private int corpId;
	private int paySeq;
	private int rcSeq;
	private int pNo;
	private int userSeq;

}
