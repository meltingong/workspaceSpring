package com.itwill.ilhajob.corp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.corp.dto.ManagerDto;
import com.itwill.ilhajob.corp.entity.Manager;
import com.itwill.ilhajob.corp.repository.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService {
	
private final ManagerRepository managerRepository;
private final ModelMapper modelMapper;
	
public ManagerServiceImpl(ManagerRepository managerRepository, ModelMapper modelMapper) {
	this.managerRepository = managerRepository;
	this.modelMapper = modelMapper;
}
	@Override
	public ManagerDto create(ManagerDto managerDto) throws Exception {
		Optional<Manager> found = managerRepository.findById(managerDto.getId());
		if(found.isPresent()) {
			new Exception();
		}
		managerRepository.save(found.get());
		return managerDto;
	}

	@Override
	public ManagerDto findManager(Long id) throws Exception {
		Optional<Manager> manager = managerRepository.findById(id);
		if(!manager.isPresent()) {
			new Exception();
		}
		return modelMapper.map(manager, ManagerDto.class);
	}

	@Override
	public ManagerDto update(ManagerDto managerDto) throws Exception {
		Optional<Manager> found = managerRepository.findById(managerDto.getId());
			Manager updateManager = modelMapper.map(managerDto,Manager.class);
			managerRepository.save(updateManager);
			return managerDto;
		}
	

	@Override
	public void remove(Long id) throws Exception {
		managerRepository.deleteById(id);
	}

	@Override
	public List<ManagerDto> findManagerByCorpID(Long corpId) {
		List<ManagerDto> managerDtoList =   managerRepository.findAll().stream()
				.map(manager -> modelMapper.map(manager, ManagerDto.class))
				.collect(Collectors.toList());
		List<ManagerDto> managerList = new ArrayList<ManagerDto>();
		
		for (ManagerDto managerDto : managerDtoList) {
			if(managerDto.getCorp().getId()==corpId) {
				managerList.add(managerDto);
			}
		}
		return managerList;
	}
	
}
