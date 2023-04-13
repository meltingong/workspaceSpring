package com.itwill.ilhajob.user.service;

import java.util.List;

import com.itwill.ilhajob.user.dto.AwardsDto;

public interface AwardsService {
	
	// save(create + update)
	AwardsDto saveAwards(AwardsDto awardsDto);
	
	// remove by awards id
	void removeAwardsById(Long id);
	
	// remove by user id
	void removeAwardsByUserId(Long userId);
	
	// find awards by awards id
	AwardsDto findAwardsById(Long id);

	// find awards list by user id
	List<AwardsDto> findAwardsByUserId(Long userId);
	
	// find all awards list
	List<AwardsDto> findAwardsList();
}
