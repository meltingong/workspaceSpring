package com.itwill.ilhajob.common.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.common.dto.AppDto;
import com.itwill.ilhajob.common.dto.CorpTagDto;
import com.itwill.ilhajob.common.dto.RecruitTagDto;
import com.itwill.ilhajob.common.entity.CorpTag;
import com.itwill.ilhajob.common.entity.RecruitTag;
import com.itwill.ilhajob.common.repository.CorpTagRepository;
import com.itwill.ilhajob.common.repository.RecruitTagRepository;

@Service
public class RecruitTagServiceImpl implements RecruitTagService{

	private final RecruitTagRepository recruitTagRepository;
	private final ModelMapper modelMapper;
	
	@Autowired
	public RecruitTagServiceImpl(RecruitTagRepository recruitTagRepository, ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
		this.recruitTagRepository = recruitTagRepository;
	}
	
	@Override
	public void insertRecruitTag(RecruitTagDto recruitTagDto) {
		RecruitTag recruitTag = modelMapper.map(recruitTagDto, RecruitTag.class);
		Optional<RecruitTag> found = recruitTagRepository.findById(recruitTag.getId());
		if(found.isPresent()) {
			new Exception("이미 같은 태그가 존재합니다");
		}
		recruitTagRepository.save(found.get());
	}
	
	@Override
	public void deleteRecruitTag(Long id) {
		Optional<RecruitTag> found = recruitTagRepository.findById(id);
		if(!found.isPresent()) {
			new Exception("삭제할 태그가 없습니다");
		}
		recruitTagRepository.deleteById(id);
	}
	
	@Override
	public List<RecruitTagDto> selectAllByRecruitId(long recruitId) {
		List<RecruitTag> recruitTagList = recruitTagRepository.findByRecruitId(recruitId);
		return recruitTagList.stream()
				.map(recruitTag ->modelMapper.map(recruitTag, RecruitTagDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<RecruitTagDto> selectAll() {
		List<RecruitTag> recruitTagList = recruitTagRepository.findAll();
		return recruitTagList.stream()
				.map(recruitTag ->modelMapper.map(recruitTag, RecruitTagDto.class))
				.collect(Collectors.toList());
	}
}
