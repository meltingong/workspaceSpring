package com.itwill.ilhajob.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.app.mapper.AppMapper;
import com.itwill.ilhajob.corp.mapper.CorpMapper;

@Repository
public class AppDaoImpl implements AppDao {

	@Autowired
	private AppMapper appMapper;
	
	@Override
	public int insertApp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteApp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<App> findAppByUserSeq(int userSeq) {
		return appMapper.findAppByUserSeq(userSeq);
	}

	@Override
	public List<App> findAppByCorpId(String coprId) {
		return appMapper.findAppByCorpId(coprId);
	}

}
