package com.itwill.ilhajob.recruitTag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.recruitTag.RecruitTag;


@Mapper
public interface RecruitTagMapper {
		//공고에서 공고태그생성
		public int insertRecruitTag(RecruitTag recruitTag);
		//태그로 공고리스트 선택
		public List<String> selectRecruitByTag(int tagId);
		//공고에서 공고태그삭제
		public int deleteRecruitTag(RecruitTag recruitTag);
		//공고태그 중복확인
		public int existedRecruitTag(RecruitTag recruitTag);
}
