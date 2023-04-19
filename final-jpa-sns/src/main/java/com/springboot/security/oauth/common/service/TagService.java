package com.springboot.security.oauth.common.service;

import java.util.List;

import com.springboot.security.oauth.common.dto.TagDto;


public interface TagService {

	TagDto selectTag(Long id);

	List<TagDto> selectAll();
	
}
