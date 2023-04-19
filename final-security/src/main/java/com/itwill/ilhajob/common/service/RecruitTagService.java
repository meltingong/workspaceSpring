package com.itwill.ilhajob.common.service;

import java.util.List;

import com.itwill.ilhajob.common.dto.RecruitTagDto;
import com.itwill.ilhajob.common.entity.RecruitTag;

public interface RecruitTagService {

	void insertRecruitTag(RecruitTagDto recruitTagDto);

	void deleteRecruitTag(Long id);

	List<RecruitTagDto> selectAllByRecruitId(long recruitId);

	List<RecruitTagDto> selectAll();

}
