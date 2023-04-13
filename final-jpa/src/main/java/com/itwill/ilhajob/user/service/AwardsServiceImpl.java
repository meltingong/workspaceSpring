package com.itwill.ilhajob.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.user.dto.AwardsDto;
import com.itwill.ilhajob.user.entity.Awards;
import com.itwill.ilhajob.user.repository.AwardsRepository;
import com.itwill.ilhajob.user.repository.UserRepository;

@Service
public class AwardsServiceImpl implements AwardsService {
	
	private final AwardsRepository awardsRepository;
	private final ModelMapper mapper;
	private final UserRepository userRepository;
	
	public AwardsServiceImpl(AwardsRepository awardsRepository, ModelMapper mapper, UserRepository userRepository) {
		this.awardsRepository = awardsRepository;
		this.mapper = mapper;
		this.userRepository = userRepository;
		
	}

	@Override
	public AwardsDto saveAwards(AwardsDto awardsDto) {
		Awards awards = mapper.map(awardsDto, Awards.class);
		awardsRepository.save(awards);
		return mapper.map(awards, AwardsDto.class);
	}

	@Override
	public void removeAwardsById(Long id) {
		awardsRepository.deleteById(id);
	}
	
	@Override
	public void removeAwardsByUserId(Long userId) {
		awardsRepository.deleteById(userId);
	}
	
	@Override
	public AwardsDto findAwardsById(Long id) {
		Awards awards = awardsRepository.findById(id).get();
		return mapper.map(awards, AwardsDto.class);
	}

	@Override
	public List<AwardsDto> findAwardsByUserId(Long userId) {
//		List<Awards> tempList = userRepository.findById(userId).get().getAwardsList();
//		List<AwardsDto> awardsList = tempList.stream().map(awards -> new AwardsDto(awards.getId(), awards.getAwardsName(), awards.getAwardsDate(), awards.getAwardsContent()))
//									.collect(Collectors.toList());
//		return awardsList;
		return null;
	}

	@Override
	public List<AwardsDto> findAwardsList() {
		List<Awards> tempList = awardsRepository.findAll();
		List<AwardsDto> awardsList = tempList.stream().map(awards -> mapper.map(tempList, AwardsDto.class)).collect(Collectors.toList());
		return awardsList;
	}
}
