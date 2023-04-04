package com.itwill.ilhajob.app;


import java.util.List;

import com.itwill.ilhajob.cv.Cv;
import com.itwill.ilhajob.recruit.Recruit;

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
	
	private int app_seq;
	private char app_status;
	
	private Recruit rc;
	private Cv cv;
	
	

}
