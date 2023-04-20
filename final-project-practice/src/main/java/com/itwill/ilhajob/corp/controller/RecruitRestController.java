package com.itwill.ilhajob.corp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.ilhajob.common.dto.CorpTagDto;
import com.itwill.ilhajob.common.dto.CorpTagWithNameDto;
import com.itwill.ilhajob.common.dto.RecruitTagDto;
import com.itwill.ilhajob.common.dto.RecruitTagWithNameDto;
import com.itwill.ilhajob.common.dto.TagDto;
import com.itwill.ilhajob.common.service.RecruitTagService;
import com.itwill.ilhajob.common.service.TagService;
import com.itwill.ilhajob.corp.dto.RecruitDto;
import com.itwill.ilhajob.corp.service.RecruitService;

@RestController
public class RecruitRestController {
	@Autowired
	private RecruitService recruitService;
	@Autowired
	private TagService tagService;
	@Autowired
	private RecruitTagService recruitTagService;
	
	@PostMapping(value="/getRecruitTag", produces = "application/json;charset=UTF-8")
	public Map<String,Object> getRecruitTagData(@RequestBody Map<String,String> data) throws Exception{
		System.out.println("컨트롤러도착");
		Map<String, Object> map = new HashMap<String,Object>();
		
		//전체태그선택
		if(data.get("tagId").equals("전체")) {
			System.out.println(data.get("tagId"));
			List<RecruitDto> recruitList = recruitService.findRecruitAll();
			List<RecruitTagDto> recruitTagList = recruitTagService.selectAll();
			List<RecruitTagWithNameDto> recruitTagNameList = new ArrayList<RecruitTagWithNameDto>();
			List<TagDto> tagList = tagService.selectAll();
			for(RecruitDto recruit : recruitList) {
				List<String> nameList = new ArrayList<String>();
				long id = 0;
				RecruitDto recruitDto = new RecruitDto();
				long tagID = 0;
				for(RecruitTagDto recruitTag:recruitTagList) {
					for(TagDto tag:tagList) {
						if(recruit.getId()==recruitTag.getRecruit().getId()) {
							if(tag.getTagId()==recruitTag.getTagId()) {
								nameList.add(tag.getTagName());
								id = recruitTag.getId();
								recruitDto = recruitTag.getRecruit();
								tagID = recruitTag.getTagId();
								}
						}
						}
					}
				 recruitTagNameList.add(new RecruitTagWithNameDto(id,
															 recruitDto,
															 tagID,
									                         nameList));
			}
			System.out.println(recruitTagNameList);
			map.put("data", recruitTagNameList);
			System.out.println("전체실행완료");
			return map;
		}else {
		//일부태그선택
		Long tagId = Long.parseLong(data.get("tagId"));
		List<RecruitTagDto> recruitTagList= recruitTagService.selectAllBytagId(tagId);
		System.out.println("전체실행완료");
		List<RecruitTagWithNameDto> recruitTagNameList = new ArrayList<RecruitTagWithNameDto>();
		List<TagDto> tagList = tagService.selectAll();
			
			for(RecruitTagDto recruitTag:recruitTagList) {
				List<String> nameList = new ArrayList<String>();
				long id = 0;
				RecruitDto recruitDto = null;
				long tagID = 0;
				for(TagDto tag:tagList) {
						if(tag.getTagId()==recruitTag.getTagId()) {
							nameList.add(tag.getTagName());
							id = recruitTag.getId();
							recruitDto = recruitTag.getRecruit();
							tagID = recruitTag.getTagId();
							}
				}
			 recruitTagNameList.add(new RecruitTagWithNameDto(id,
														 recruitDto,
														 tagID,
								                         nameList));
		}
		map.put("data", recruitTagNameList);
		System.out.println("태그선택실행완료");
		return map;
		}
	}
}
