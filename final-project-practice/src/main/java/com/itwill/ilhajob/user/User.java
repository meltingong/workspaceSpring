package com.itwill.ilhajob.user;

import java.util.List;

import com.itwill.ilhajob.app.App;
import com.itwill.ilhajob.awards.Awards;
import com.itwill.ilhajob.cv.Cv;
import com.itwill.ilhajob.edu.Edu;
import com.itwill.ilhajob.exp.Exp;
import com.itwill.ilhajob.review.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 *  사용자관리를 위하여 필요한 도메인클래스(VO,DTO)
 *  USERINFO 테이블의 각컬럼에해당하는 멤버를 가지고있다
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {
	
	private int userSeq;
	private String userEmail;
	private String userPassword;
	private String userName;
	private String userPhone;
	private String userSex;
	private String userAddress;
	private String userCareer;
	private int userAge;
	private String userFinalEducation;
	private String userLanguage;
	private String userSkills;
	private String userImage;
	private String userStatus;
	private String snsType;
	private String snsId;
	private String job;
	private int role;
	
	private List<App> appList;
	private List<Exp> expList;
	private List<Edu> eduList;
	private List<Awards> awardsList;
	private List<Review> reviewList;
	

	public User(String userEmail, String userPassword, String snsType, String snsId) {
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.snsType = snsType;
		this.snsId = snsId;
	}

	/*
	 *패쓰워드 일치여부 검사 
	 */
	public boolean isMatchPassword(String password){
		boolean isMatch=false;
		if(this.userPassword.equals(password)){
			isMatch=true;
		}
		return isMatch;
	}




}







