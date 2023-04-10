package com.itwill.ilhajob.app;


import java.util.List;

import com.itwill.ilhajob.corp.Corp;
import com.itwill.ilhajob.cv.Cv;
import com.itwill.ilhajob.recruit.Recruit;
import com.itwill.ilhajob.user.User;

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
public class App {
	
	private int appSeq;
	private char appStatus;

	private Recruit rc;
	private Cv cv;
	
	private int userSeq;
	private String corpId;
	private int rcSeq;
	
	private List<Cv> cvList;
	
	
	

}
