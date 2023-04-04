package com.itwill.ilhajob.recruitTag;

import java.util.List;

public interface RecruitTagDao {
		//공고에서 공고태그생성
		public int insertRecruitTag(RecruitTag recruitTag);
		//태그로 공고리스트 선택
		public List<String> selectRecruitByTag(int tagId);
		//공고에서 공고태그삭제
		public int deleteRecruitTag(int rcSeq,int tagId);
		//공고태그 중복확인
		public boolean existedRecruitTag(int rcSeq,int tagId);
}
