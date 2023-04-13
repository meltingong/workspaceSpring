package com.itwill.ilhajob.common.service;

import java.util.List;

import com.itwill.ilhajob.common.dto.AppDto;

public interface AppService {
	
	void insertApp(AppDto appDto);
	
	void deleteApp(Long id);
	
	List<AppDto> findAllByRecruitId(long id);
	List<AppDto> findAllByCvId(long id);
}
