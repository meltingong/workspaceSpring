package com.springboot.security.oauth.common.service;

import java.util.List;

import com.springboot.security.oauth.common.dto.RecruitTagDto;


public interface RecruitTagService {

	void insertRecruitTag(RecruitTagDto recruitTagDto);

	void deleteRecruitTag(Long id);

	List<RecruitTagDto> selectAllByRecruitId(long recruitId);

	List<RecruitTagDto> selectAll();

}
