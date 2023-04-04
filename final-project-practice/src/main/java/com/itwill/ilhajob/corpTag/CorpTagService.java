package com.itwill.ilhajob.corpTag;

import java.util.List;

public interface CorpTagService {
	//기업태그 생성
	public int insertCorpTag(CorpTag corpTag);
	//태그별로 기업 아이디 출력
	public List<String> selectCorpByTag(int tagId);
	//기업에서 기업태그삭제
	public int deleteCorpTag(String corpId,int tagId);
	//기업 중복 체크
}
