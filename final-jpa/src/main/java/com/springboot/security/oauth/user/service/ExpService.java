package com.springboot.security.oauth.user.service;

import java.util.List;

import com.springboot.security.oauth.user.dto.ExpDto;


public interface ExpService {
	ExpDto createExp(ExpDto expDto);
	
	ExpDto updateExp(Long id, ExpDto expDto);
	
	void removeById(Long id);
	
	List<ExpDto> findExpListByUserId(Long userId);
	
	List<ExpDto> findAll();
}
