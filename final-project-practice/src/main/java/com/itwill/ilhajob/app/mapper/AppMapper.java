package com.itwill.ilhajob.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.app.App;

@Mapper
public interface AppMapper {
	
	int insertApp();
	
	int deleteApp();
	
	List<App> findAppByUserSeq(int userSeq);
	
	List<App> findAppByCorpId(String coprId);
}
