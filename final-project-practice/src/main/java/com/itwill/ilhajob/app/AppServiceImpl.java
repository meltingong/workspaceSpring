package com.itwill.ilhajob.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.cv.Cv;

@Service
public class AppServiceImpl implements AppService {
	@Autowired	
	private AppDao appDao;

	@Override
	public int insertApp(App app) {
		return appDao.insertApp(app);
	}

	@Override
	public int deleteApp(int appSeq) {
		return appDao.deleteApp(appSeq);
	}
	
	
	//CorpId로 지원한 app 수
	@Override
	public int findAppCountByCorpId(String corpId) {
		return appDao.findAppCountByCorpId(corpId);
	}
	
	//공고(a.rc_seq=2)에 지원한 사람들의 이력서 목록 불러오기
	@Override
	public App findCvListByRcSeq(int rcSeq) {
		return appDao.findCvListByRcSeq(rcSeq);
	}
	
	
	
	
}
