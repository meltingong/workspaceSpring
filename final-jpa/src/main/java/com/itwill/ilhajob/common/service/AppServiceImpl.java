package com.itwill.ilhajob.common.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.common.dto.AppDto;
import com.itwill.ilhajob.common.entity.App;
import com.itwill.ilhajob.common.repository.AppRepository;

@Service
public class AppServiceImpl implements AppService {

	private final AppRepository appRepository;
	private final ModelMapper modelMapper;
	
	@Autowired	
	public AppServiceImpl(AppRepository appRepository, ModelMapper modelMapper) {
		this.appRepository = appRepository;
		this.modelMapper = modelMapper;
	}

		@Override
	public void insertApp(AppDto appDto) {
		App createApp = modelMapper.map(appDto, App.class);
		appRepository.save(createApp);
	}

	@Override
	public void deleteApp(Long id) {
		appRepository.deleteById(id);
	}

	@Override
	public Long findAppCountByCorpId(long id) {
		return 1l;
	}
	
	
}
