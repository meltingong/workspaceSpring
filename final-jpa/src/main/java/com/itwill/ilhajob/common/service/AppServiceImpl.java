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

	//주로 appStatus 변경
	@Transactional
	@Override
	public void updateApp(long id, int appStatus) {
		App findApp = appRepository.findById(id).get();
		AppDto updateDto = modelMapper.map(findApp, AppDto.class);
		updateDto.setAppStatus(appStatus);
		modelMapper.map(updateDto, findApp);
		appRepository.save(findApp);
	}
	
	@Override
	public void deleteApp(Long id) {
		appRepository.deleteById(id);
	}

	/*
	 * 기업이 등록한 공고리스트뷰에서 공고하나 클릭시 appList출력하여 이력서리스트 확인
	 */
	@Transactional
	@Override
	public List<AppDto> findAllByRecruitId(long id) {
		List<App> appList = appRepository.findAppsByRecruitId(id);
		return appList.stream()
				.map(app ->modelMapper.map(app, AppDto.class))
				.collect(Collectors.toList());
	}
	/*
	 * 구직자가 지원한 appList출력하여 공고리스트 확인
	 */
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
