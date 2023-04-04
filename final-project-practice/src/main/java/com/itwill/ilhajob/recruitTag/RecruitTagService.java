package com.itwill.ilhajob.recruitTag;

import java.util.List;

public interface RecruitTagService {
	//공고에서 공고태그생성 (공고태그 생성시 중복 유효성검사)
	public int insertRecruitTag(RecruitTag recruitTag);
	//태그로 공고리스트 선택
	public List<String> selectRecruitByTag(int tagId);
	//공고에서 공고태그삭제
	public int deleteRecruitTag(int rcSeq,int tagId);
}
