package com.itwill.ilhajob.exp;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Exp {
	
	private int expSeq;
	private String expPosition;
	private String expCorpName;
	private Date expStartDate;
	private Date expEndDate;
	private String expContent;
	private int userSeq;
	
}
