package com.itwill.ilhajob.common.service;

import com.itwill.ilhajob.common.dto.AppDto;

public interface AppService {
	
	void insertApp(AppDto appDto);
	
	void deleteApp(Long id);
	
	Long findAppCountByCorpId(String corpLoginId);
}
