package com.springboot.security.oauth.common.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.security.oauth.common.dto.AppDto;
import com.springboot.security.oauth.common.entity.App;
import com.springboot.security.oauth.common.repository.AppRepository;
import com.springboot.security.oauth.corp.dto.RecruitDto;
import com.springboot.security.oauth.corp.entity.Recruit;
import com.springboot.security.oauth.corp.repository.RecruitRepository;
import com.springboot.security.oauth.user.entity.Message;
import com.springboot.security.oauth.user.repository.MessageRepository;


@Service
public class AppServiceImpl implements AppService {

	private final AppRepository appRepository;
	private final RecruitRepository recruitRepository;
	private final MessageRepository messageRepository; 
	private final ModelMapper modelMapper;
	
	@Autowired	
	public AppServiceImpl(AppRepository appRepository, 
							RecruitRepository recruitRepository, 
							MessageRepository messageRepository,
							ModelMapper modelMapper) {
		this.appRepository = appRepository;
		this.recruitRepository = recruitRepository;
		this.messageRepository = messageRepository;
		this.modelMapper = modelMapper;
	}
	
	//지원하기시 공고rcAppCount(지원자숫자) 증가
	@Transactional
	@Override
	public void insertApp(AppDto appDto) {
		RecruitDto recruitDto = appDto.getRecruit();
		recruitDto.setRcAppCount(recruitDto.getRcAppCount()+1);
		Recruit recruit = modelMapper.map(recruitDto, Recruit.class);
		recruitRepository.saveAndFlush(recruit);
		
		appDto.setRecruit(modelMapper.map(recruit, RecruitDto.class));
		App createApp = modelMapper.map(appDto, App.class);
		appRepository.save(createApp);
	}

	//주로 appStatus 변경
	@Transactional
	@Override
	public void updateApp(long id, int appStatus) {
		/*
		 * appStatus
		 * 0 : 접수중(디폴트)
		 * 1 : 접수확인
		 * 2 : 합격
		 * ?? 3 : 불합격
		 */
		App findApp = appRepository.findById(id).get();
		AppDto updateDto = modelMapper.map(findApp, AppDto.class);
		if(appStatus==1) {
			updateDto.setAppStatus(appStatus);
			modelMapper.map(updateDto, findApp);
			findApp = appRepository.save(findApp);
			Message applyMessage = new Message();
			applyMessage.setMessageTitle("["+findApp.getRecruit().getRcTitle()+"] 접수확인");
			applyMessage.setMessageContents("채용담당자가 이력서를 확인했습니다.");
			applyMessage.setMessageDate(LocalDateTime.now());
			applyMessage.setUser(findApp.getUser());
			applyMessage = messageRepository.save(applyMessage);
		}
		else if(appStatus==2) {
			updateDto.setAppStatus(appStatus);
			modelMapper.map(updateDto, findApp);
			findApp = appRepository.save(findApp);
			Message applyMessage = new Message();
			applyMessage.setMessageTitle("["+findApp.getRecruit().getRcTitle()+"] 서류합격");
			applyMessage.setMessageContents(findApp.getUser().getUserName()+"님은 서류에 합격 하셨습니다.");
			applyMessage.setMessageDate(LocalDateTime.now());
			applyMessage.setUser(findApp.getUser());
			applyMessage = messageRepository.save(applyMessage);
		}
		else if(appStatus==3) {
			updateDto.setAppStatus(appStatus);
			modelMapper.map(updateDto, findApp);
			findApp = appRepository.save(findApp);
			Message applyMessage = new Message();
			applyMessage.setMessageTitle("["+findApp.getRecruit().getRcTitle()+"] 서류불합격");
			applyMessage.setMessageContents(findApp.getUser().getUserName()+"님은 서류에 불합격 하셨습니다.");
			applyMessage.setMessageDate(LocalDateTime.now());
			applyMessage.setUser(findApp.getUser());
			applyMessage = messageRepository.save(applyMessage);
		}
		else {
			
		}
	}
	
	@Transactional
	@Override
	public void deleteApp(Long id) {
		App app = appRepository.findById(id).get();
		AppDto appDto = modelMapper.map(app, AppDto.class);
		RecruitDto recruitDto = appDto.getRecruit();
		recruitDto.setRcAppCount(recruitDto.getRcAppCount()-1);
		Recruit recruit = modelMapper.map(recruitDto, Recruit.class);
		recruitRepository.saveAndFlush(recruit);
		
		appRepository.deleteById(id);
	}

	/*
	 * 기업이 등록한 공고리스트뷰에서 공고하나 클릭시 appList출력하여 이력서리스트 확인
	 */
	@Transactional
	@Override
	public List<AppDto> findAllByRecruitId(long id) throws Exception {
		List<App> appList = appRepository.findAppsByRecruitId(id);
		
		//이력서 없을 때 예외 메세지 띄우기
		if(appList.size()==0) {
			throw new Exception("제출된 이력서가 없습니다!");
		}
		return appList.stream()
				.map(app ->modelMapper.map(app, AppDto.class))
				.collect(Collectors.toList());
	}
	
	/*
	 * 기업이 등록한 공고리스트뷰에서 공고하나 클릭시 appList출력하여 이력서리스트 확인->지원자 수 뽑기
	 */

	
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
