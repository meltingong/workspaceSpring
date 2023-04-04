package com.itwill.ilhajob.awards;

import java.util.List;

public interface AwardsService {
	
	/*
	 *  awards create
	 */
	int createAwards(Awards awards);
	
	/*
	 *  awards update
	 */
	int updateAwards(Awards awards);
	
	/*
	 *  awards remove
	 */
	int removeAwardsBySeq(int awardsSeq);
	
	/*
	 *  userSeq로 awards remove 하기
	 */
	int removeAwardsByUserSeq(int userSeq);
	
	/*
	 *  findAwards( 수상seq로 찾기 )
	 */
	Awards findAwards(int awardsSeq);
	
	/*
	 * findAwardsList(수상list - admin용)
	 */
	List<Awards> findAwardsList();
	
	/*
	 * findAwards (회원 seq로 찾기)
	 */
	List<Awards> findAwardsOfUser(int userSeq);
}
