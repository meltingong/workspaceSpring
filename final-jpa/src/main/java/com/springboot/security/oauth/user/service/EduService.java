package com.springboot.security.oauth.user.service;

import java.util.List;

import com.springboot.security.oauth.user.dto.EduDto;


public interface EduService {
	EduDto createEdu(EduDto eduDto);

	EduDto updateEdu(Long id, EduDto eduDto);

	void deleteEdu(Long id);

	List<EduDto> findEduListByUserId(Long userId);

	List<EduDto> findAll();
}
