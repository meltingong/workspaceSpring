package com.itwill.ilhajob.app;

import java.util.List;

import com.itwill.ilhajob.app.mapper.AppMapper;

public interface AppDao {
	
	int insertApp();
	
	int deleteApp();
	
	List<App> findAppByUserSeq(int userSeq);
	
	List<App> findAppByCorpId(String coprId);
}
