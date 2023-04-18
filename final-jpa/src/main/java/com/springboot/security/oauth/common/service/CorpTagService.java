package com.springboot.security.oauth.common.service;
import java.util.List;

import com.springboot.security.oauth.common.dto.CorpTagDto;


public interface CorpTagService {

	void insertCorpTag(CorpTagDto corpTagDto);

	void deleteCorpTag(Long id);

	List<CorpTagDto> selectAllByCorpId(Long corpid);
	
	List<CorpTagDto> selectAll();
	
}
