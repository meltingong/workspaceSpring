package com.itwill.ilhajob.corpTag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.corpTag.CorpTag;

@Mapper
public interface CorpTagMapper {
	//기업태그 생성
	public int insertCorpTag(CorpTag corpTag);
	//태그별로 기업 아이디 출력
	public List<String> selectCorpByTag(int tagId);
	//기업에서 기업태그삭제
	public int deleteCorpTag(CorpTag corpTag);
	//기업 중복 체크
	public int existedCorpTag(CorpTag corpTag);
}
