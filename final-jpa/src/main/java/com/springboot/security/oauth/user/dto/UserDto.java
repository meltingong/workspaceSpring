package com.springboot.security.oauth.user.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.springboot.security.oauth.user.entity.User;
import com.springboot.security.oauth.util.validation.annotation.Email;
import com.springboot.security.oauth.util.validation.annotation.Nickname;
import com.springboot.security.oauth.util.validation.annotation.Password;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/*
 *  사용자관리를 위하여 필요한 도메인클래스(VO,DTO)
 *  USERINFO 테이블의 각컬럼에해당하는 멤버를 가지고있다
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
public class UserDto {
    private Long id;
    @Email
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userPhone;
    private LocalDateTime userCreateDate;
    private String userSex;
    private String userAddress;
    private String userCareer;
    private Integer userAge;
    private String userFinalEducation;
    private String userLanguage;
    private String userSkills;
    private String userImage;
    private String provider;
    @Nickname
    private String nickname;
    private String job;
    private int role;
    
	public UserDto(Long id, String userEmail, String userPassword) {
		this.id = id;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	@Getter
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Join {
		@Nickname
		private String nickname;
		@Email
		private String userEmail;
		private String password;
	}
	@Getter
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class UpdatePassword {
//        @Password
		private String oldPassword;

		@Password
		private String newPassword;

	}

	@Getter
	@ToString
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class findPassword {
		@Email
		private String userEmail;

		@Nickname
		private String nickname;
	}

	@Getter
	@ToString
	public static class Response {
		private Long id;
		private String nickname;
		private String userEmail;
	}

	public static Response entityToDto(User user) {
		Response response = new Response();
		response.id = user.getId();
		response.nickname = user.getNickname();
		response.userEmail = user.getUserEmail();
		return response;
	}
	
    
}






