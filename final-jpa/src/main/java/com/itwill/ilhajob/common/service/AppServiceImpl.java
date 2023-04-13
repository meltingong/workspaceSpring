package com.itwill.ilhajob.common.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.common.dto.AppDto;
import com.itwill.ilhajob.common.entity.App;
import com.itwill.ilhajob.common.repository.AppRepository;
import com.itwill.ilhajob.corp.dto.RecruitDto;

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

	//주로 appStatus 변경일듯
	public void updateApp(long id, AppDto appDto) {
		App updateApp = appRepository.findById(id).get();
		appDto.setId(id);
		modelMapper.map(appDto, updateApp);
		appRepository.save(updateApp);
	}
	
	@Override
	public void deleteApp(Long id) {
		appRepository.deleteById(id);
	}

	/*
	 * corp 등록한공고리스트뷰에서 공고하나 클릭시 등록된 이력서들 출력
	 */
	@Transactional
	@Override
	public List<AppDto> findAllByRecruitId(long id) {
		List<App> appList = appRepository.findAppsByRecruitId(id);
		return appList.stream()
				.map(app ->modelMapper.map(app, AppDto.class))
				.collect(Collectors.toList());
	}
	@Transactional
	@Override
	public List<AppDto> findAllByUserId(long id) {
		List<App> appList = appRepository.findAppsByUserId(id);
		return appList.stream()
				.map(app ->modelMapper.map(app, AppDto.class))
				.collect(Collectors.toList());
	}
	/*
	 * 이력서리스트에서 특정이력서 클릭시 지원한 공고들 출력
	 * but, 구직자가 지원한 공고리스트 필요
	 */
	@Transactional
	@Override
	public List<AppDto> findAllByCvId(long id) {
		List<App> appList = appRepository.findAppsByCvId(id);
		return appList.stream()
				.map(app ->modelMapper.map(app, AppDto.class))
				.collect(Collectors.toList());
	}

	
}
