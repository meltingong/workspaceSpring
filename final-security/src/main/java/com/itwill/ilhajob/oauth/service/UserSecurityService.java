package com.itwill.ilhajob.oauth.service;

import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.ilhajob.oauth.util.CustomMailSender;
import com.itwill.ilhajob.oauth.util.exception.CustomException;
import com.itwill.ilhajob.oauth.util.exception.ErrorCode;
import com.itwill.ilhajob.user.dto.UserDto;
import com.itwill.ilhajob.user.entity.User;
import com.itwill.ilhajob.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserSecurityService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final CustomMailSender customMailSender;

    /**
     * form회원가입
     * @exception : 존재하는 이메일이라면 ErrorCode.EMAIL_DUPLICATED
     * @exception : 존재하는 닉네임이라면 ErrorCode.NICKNAME_DUPLICATED
     */
    public Long join(UserDto.Join userDTO) {
        String encodePassword = bCryptPasswordEncoder.encode(userDTO.getPassword());
        joinEmailDuplicatedCheck(userDTO.getUserEmail());
        joinNicknameDuplicatedCheck(userDTO.getNickname());

        User user = User.JoinForm()
                .userEamil(userDTO.getUserEmail())
                .nickname(userDTO.getNickname())
                .password(encodePassword).build();

        userRepository.save(user);
        return user.getId();
    }

    /**
     * form회원가입 - 이메일 중복체크
     * @exception : 존재하는 이메일이라면 ErrorCode.EMAIL_DUPLICATED
     */
    public boolean joinEmailDuplicatedCheck(String email) {
        userRepository.findByUserEmail(email).ifPresent(m -> {
            throw new CustomException(ErrorCode.EMAIL_DUPLICATED);
        });
        return true;
    }

    /**
     * form회원가입 - 닉네임 중복체크
     * @exception : 존재하는 닉네임이라면 ErrorCode.NICKNAME_DUPLICATED
     */
    public boolean joinNicknameDuplicatedCheck(String nickname) {
        userRepository.findByNickname(nickname).ifPresent(m -> {
            throw new CustomException(ErrorCode.NICKNAME_DUPLICATED);
        });
        return true;
    }


    /**
     * 닉네임 수정
     * @param memberId
     * @param updateNickname
     * @exception : 일치하는 memberId 없으면 -> ErrorCode.ID_NOT_FOUND
     * @exception : 중복되는 닉네임이 있다면 -> ErrorCode.NICKNAME_DUPLICATED
     * @exception : 닉네임이 이전과 같다면 -> ErrorCode.NICKNAME_EQUAL_PREVIOUS
     */
    public void updateNickname(Long userId, String updateNickname) {
       User user = userRepository.findById(userId).orElseThrow(() ->
            new CustomException(ErrorCode.ID_NOT_FOUND)
        );

        userRepository.findByNickname(updateNickname).ifPresent((member1) -> {
            throw new CustomException(ErrorCode.NICKNAME_DUPLICATED);
        });

        if(user.getNickname().equals(updateNickname)){
            throw new CustomException(ErrorCode.NICKNAME_EQUAL_PREVIOUS);
        }

        user.changeNickname(updateNickname);
    }

    /**
     * 패스워드 수정
     * @param memberId
     * @param memberDTO
     * @exception : 일치하는 memberId 없으면 -> ErrorCode.ID_NOT_FOUND
     * @exception : 기존 비밀번호와 DB 비밀번호가 불일치하면 -> ErrorCode.PASSWORD_NOT_EQUAL
     * @exception : 기존 비밀번호와 새 비밀번호가 일치하면 -> ErrorCode.PASSWORD_EQUAL_PREVIOUS
     */
    public void updatePassword(Long userId, UserDto.UpdatePassword userDto) {
         User user = userRepository.findById(userId).orElseThrow(() ->
            new CustomException(ErrorCode.ID_NOT_FOUND)
        );

        //DB에 저장된 비밀번호와 사용자가 입력한 기존 비밀번호 같아야 새 비밀번호로 변경 가능하다.
        if(! bCryptPasswordEncoder.matches(userDto.getOldPassword(), user.getUserPassword())){
            throw new CustomException(ErrorCode.PASSWORD_NOT_EQUAL);
        }

        //기존 비밀번호와 새 비밀번호가 같다면 변경하지 않는다.
        if(bCryptPasswordEncoder.matches(userDto.getNewPassword(), user.getUserPassword())){
            throw new CustomException(ErrorCode.PASSWORD_EQUAL_PREVIOUS);
        }

        String encodePassword = bCryptPasswordEncoder.encode(userDto.getNewPassword());
        user.changePassword(encodePassword);
    }


    /**
     * 회원조회
     * @param memberId
     * @exception : 일치하는 memberId 없으면 -> ErrorCode.ID_NOT_FOUND
     * @return MemberDTO.Response
     */
    public UserDto.Response detail(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new CustomException(ErrorCode.ID_NOT_FOUND)
        );

        UserDto.Response response = UserDto.entityToDto(user);
        return response;
    }

    /**
     * 비밀번호 찾기
     * @param memberDTO
     * @exception : 일치하는 이메일 없으면 -> ErrorCode.EMAIL_NOT_FOUND
     * @exception : 이메일의 member와 닉네임이 다르면 -> ErrorCode.NICKNAME_NOT_EQUAL
     */
    public void findPassword(UserDto.findPassword userDto) {
        User user = userRepository.findByUserEmail(userDto.getUserEmail()).orElseThrow(() ->
                new CustomException(ErrorCode.EMAIL_NOT_FOUND)
        );

        if(! user.getNickname().equals(userDto.getNickname())){
            throw new CustomException(ErrorCode.NICKNAME_NOT_EQUAL);
        }

        //임시 비밀번호
        UUID uid = UUID.randomUUID();
        String tempPassword = uid.toString().substring(0,10) + "p2$";
        customMailSender.sendFindPasswordMail(userDto, tempPassword);

        tempPassword = bCryptPasswordEncoder.encode(tempPassword);
        user.changePassword(tempPassword);
    }
}
