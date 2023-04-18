package com.itwill.ilhajob.common.service;

import java.util.List;

import com.itwill.ilhajob.common.dto.CorpTagDto;

public interface CorpTagService {

	void insertCorpTag(CorpTagDto corpTagDto);

	void deleteCorpTag(Long id);

	List<CorpTagDto> selectAllByCorpId(Long corpid);
	
	List<CorpTagDto> selectAll();
	
}
