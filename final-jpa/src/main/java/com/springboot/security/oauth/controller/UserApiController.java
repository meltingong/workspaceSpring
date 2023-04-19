package com.springboot.security.oauth.controller;


import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.security.oauth.service.UserSecurityService;
import com.springboot.security.oauth.user.dto.UserDto;
import com.springboot.security.oauth.util.aop.ReturnBindingResultError;
import com.springboot.security.oauth.util.validation.annotation.Email;
import com.springboot.security.oauth.util.validation.annotation.Nickname;
import com.springboot.security.oauth.util.validation.annotation.Password;

import lombok.RequiredArgsConstructor;

@Validated  //requestparam, pathvariable의 경우는 클래스레벨에 붙여서 검증해야한다. //메서드레벨에 붙여서 검증하는건 modelattribute, requestbody이다.
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {
    private final UserSecurityService userSecurityService;

    /**
     * 회원가입 - 저장
     */
    /*
    @PostMapping("")
    @ReturnBindingResultError
    public ResponseEntity join(@Validated @RequestBody UserDto.Join userDto, BindingResult bindingResult){
        Long memberId = userSecurityService.join(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(memberId);
    }
	*/
    
    /**
     * 회원가입 - 이메일 검증 및 중복체크
     */
    @PostMapping("/userEmail/check/{userEmail}")
    public boolean joinEmailCheck(@PathVariable @Email String userEmail){
        return userSecurityService.joinEmailDuplicatedCheck(userEmail);
    }

    /**
     * 회원가입 - 닉네임 검증 및 중복체크
     */
    @PostMapping("/nickname/check/{nickname}")
    public boolean joinNicknameCheck(@PathVariable @Nickname String nickname){
        return userSecurityService.joinNicknameDuplicatedCheck(nickname);
    }

    /**
     * 회원가입 - 비밀번호 양식 일치 확인
     * (javascript에서 검증로직 추가하는 것으로 변경하자. 채팅 기능까지 완료 후에 추가할 예정)
     */
    @PostMapping("/password/check")
    public boolean joinPasswordCheck(@RequestBody Map<String, @Password String> map){
        return true;
    }

    /**
     * 닉네임 수정
     */
    @PutMapping("/{userId}/nickname/{updateNickname}")
    public ResponseEntity updateNickname(@PathVariable Long userId, @PathVariable @Nickname String updateNickname){
    	userSecurityService.updateNickname(userId, updateNickname);
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }

    /**
     * 비밀번호 수정
     */
    @PutMapping("/{userId}/password")
    @ReturnBindingResultError
    public ResponseEntity updatePassword(
            @PathVariable Long userId,
            @Validated @RequestBody UserDto.UpdatePassword userDto, BindingResult bindingResult
    ){
    	userSecurityService.updatePassword(userId, userDto);
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }

    /**
     * 비밀번호 찾기
     */
    @PostMapping("/findPassword")
    @ReturnBindingResultError
    public ResponseEntity findPassword(@Validated @RequestBody UserDto.findPassword userDto, BindingResult bindingResult){
    	userSecurityService.findPassword(userDto);
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }

    /**
     * 회원조회
     */
    @GetMapping("/{userId}")
    public ResponseEntity detail(@PathVariable Long userId){
        UserDto.Response response = userSecurityService.detail(userId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
