package com.itwill.ilhajob.user.service;

import java.util.List;

import com.itwill.ilhajob.user.dto.CvDto;

public interface CvService {
	
	// save
	CvDto saveCv(CvDto cvDto);
	
	// update
	CvDto updateCv(Long id, CvDto cvDto);
	
	// remove by cv id
	void removeById(Long id);
	
	// find cv by cv id
	CvDto findCvById(Long id);
	
	// find cv by user id
	List<CvDto> findCvByUserId(Long userId);
	
	// find all
	List<CvDto> findCvAll();
	
	//한 회사가 올린 공고 하나의 이력서 목록 불러오기
	//List<Cv> findCvListByCorpId(String corpId);
}
