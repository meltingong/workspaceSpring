package com.itwill.ilhajob.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.app.App;
import com.itwill.ilhajob.cv.Cv;

@Mapper
public interface AppMapper {
	
	int insertApp(App app);
	
	int deleteApp(int appSeq);
	
	int findAppCountByCorpId(String corpId);
	
	//공고(a.rc_seq=2)에 지원한 사람들의 이력서 목록 불러오기
	App findCvListByRcSeq(int rcSeq);
	 
	
	//List<App> findAppByUserSeq(int userSeq); -> 유저가함(usermapper.xml 작성완료되어있는거 확인완료 04.04 18:12)
	
	//List<App> findAppByCorpId(String coprId); -> 회사가 함
}
