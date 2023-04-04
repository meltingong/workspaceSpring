package com.itwill.ilhajob.cv;

import java.util.List;

import org.springframework.lang.Nullable;

import com.itwill.ilhajob.app.App;
import com.itwill.ilhajob.awards.Awards;
import com.itwill.ilhajob.edu.Edu;
import com.itwill.ilhajob.exp.Exp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Cv {

	private int cvSeq;
	private String cvName;
	private String cvDescription;
	private String cvPortfolio;
	private int userSeq;
	private List<Edu> eduList;
	private List<Exp> expList;
	private List<Awards> awardsList;
	
	public Cv(int cvSeq, String cvName, String cvDescription, String cvPortfolio, int userSeq) {
		this.cvSeq = cvSeq;
		this.cvName = cvName;
		this.cvDescription = cvDescription;
		this.cvPortfolio = cvPortfolio;
		this.userSeq = userSeq;
	}
	
	
	
}
