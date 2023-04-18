package com.springboot.security.oauth.user.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.springboot.security.oauth.domain.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@SequenceGenerator(name = "user_id_SEQ_gen",
				   sequenceName = "user_id_SEQ",
				   allocationSize = 1)
@Table(name = "userinfo")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "user_id_SEQ_gen")
	private Long id;

	@NonNull
	@Column(nullable = false)
	private String userEmail;
	
	@NonNull
	@Column(nullable = false)
	private String userPassword;
	
	private String userName;
	
	private String userPhone;
	
	private LocalDateTime userCreateDate;
	
	private String userSex;
	
	@Column(length = 600)
	private String userAddress;
		
	private String userCareer;
	
	private Integer userAge;
	
	private String userFinalEducation;
	
	private String userLanguage;
	
	@Column(length = 300)
	private String userSkills;
	
	private String userImage;
	// snstype 를 provider로 변경
	private String provider;
	// snsid 를 nickname으로 변경
	private String nickname;
	
	private String job;
	
	private int role;
	
   // @Enumerated(EnumType.STRING)
   // private Role role2 = Role.ROLE_USER;
	@Builder(builderClassName = "JoinForm", builderMethodName = "JoinForm")
	public User(String nickname, String userEamil, String password) {
		this.nickname = nickname;
		this.userEmail = userEamil;
		this.userPassword = password;
	}
	
	
	@Builder(builderClassName = "JoinOAuth2", builderMethodName = "JoinOAuth2")
	public User(String userEmail, @NonNull String userPassword,String provider,String nickname) {
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.provider = provider;
		this.nickname = nickname;
	}
	
	 public void changeNickname(String updateNickname) {
	        this.nickname = updateNickname;
	    }

	    public void changePassword(String newPassword) {
	        this.userPassword = newPassword;
	    }
	
	
    @PrePersist
    public void prePersist() {
        this.role = this.role == 0 ? 1 : this.role;
    }






}
