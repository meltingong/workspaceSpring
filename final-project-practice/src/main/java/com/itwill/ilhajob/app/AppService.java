package com.itwill.ilhajob.app;

import java.util.List;

import com.itwill.ilhajob.cv.Cv;

public interface AppService {
	
	int insertApp(App app);
	
	int deleteApp(int appSeq);
	
	int findAppCountByCorpId(String corpId);
	
	//공고(a.rc_seq=2)에 지원한 사람들의 이력서 목록 불러오기
	App findCvListByRcSeq(int rcSeq);

	
}
