package com.springboot.security.oauth.domain.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.springboot.security.oauth.domain.enums.Role;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter 
@ToString
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "member_id")
    private Long id;

    private String nickname;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role = Role.ROLE_USER;

    private String provider;

    @Builder(builderClassName = "JoinForm", builderMethodName = "JoinForm")
    public Member(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    @Builder(builderClassName = "JoinOAuth2", builderMethodName = "JoinOAuth2")
    public Member(String nickname, String email, String password, String provider) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.provider = provider;
    }

    public Member() {
    }

    //테스트용
    public Member(String email, String nickname) {
        this.nickname = nickname;
        this.email = email;
    }

    public void changeNickname(String updateNickname) {
        this.nickname = updateNickname;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

}
