package com.itwill.ilhajob.app;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.app.mapper.AppMapper;
import com.itwill.ilhajob.cv.Cv;
import com.itwill.ilhajob.user.User;
@Repository
public interface AppDao {
	
	int insertApp(App app);
	
	int deleteApp(int appSeq);
	
	int findAppCountByCorpId(String corpId);
	
	//공고(a.rc_seq=2)에 지원한 사람들의 이력서 목록 불러오기
	App findCvListByRcSeq(int rcSeq);
	
	//List<App> findAppByUserSeq(int userSeq);
	
	//List<App> findAppByCorpId(String coprId);

	
}
