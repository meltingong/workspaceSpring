package com.springboot.security.oauth.common.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.security.oauth.common.dto.TagDto;
import com.springboot.security.oauth.common.entity.Tag;
import com.springboot.security.oauth.common.repository.TagRepository;


@Service
public class TagServiceImpl implements TagService{

	@Autowired
	TagRepository tagRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public TagDto selectTag(Long id) {
		
		Optional<Tag> found = tagRepository.findById(id);
		if(!found.isPresent()) {
			new Exception("태그가 없습니다");
		}
		TagDto tag = modelMapper.map(found.get(), TagDto.class);
		return tag;
	}

	@Override
	public List<TagDto> selectAll() {
		List<Tag> tagList = tagRepository.findAll();
		return tagList.stream()
				.map(tag ->modelMapper.map(tag, TagDto.class))
				.collect(Collectors.toList());
	}

	
}
