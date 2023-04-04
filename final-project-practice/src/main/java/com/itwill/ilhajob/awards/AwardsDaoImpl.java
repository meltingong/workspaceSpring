package com.itwill.ilhajob.awards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.awards.mapper.AwardsMapper;

@Repository
public class AwardsDaoImpl implements AwardsDao{
	@Autowired
	private AwardsMapper awardsMapper;
	
	/*
	 * 수상seq로 찾기
	 */
	@Override
	public Awards findAwards(int awardsSeq) {
		return  awardsMapper.selectByAwards(awardsSeq);
	}

	@Override
	public int createAwards(Awards awards) {
		return awardsMapper.insertAwards(awards);
	}

	@Override
	public int updateAwards(Awards awards) {
		return awardsMapper.updateAwards(awards);
	}

	
	
	@Override
	public int removeAwardsBySeq(int awardsSeq) {
		return awardsMapper.removeAwardsBySeq(awardsSeq);
	}
	
	
	
	/*
	 * 수상 전체 리스트(admin 필요)
	 */
	@Override
	public List<Awards> findAwardsList() {
		return awardsMapper.selectAll();
	}
	/*
	 *  한명의 유저로 수상찾기(userSEQ 찾기)
	 */
	@Override
	public List<Awards> findAwardsOfUser(int userSeq) {
		return awardsMapper.selectByAwardsOfUser(userSeq);
	}

	@Override
	public int removeAwardsByUserSeq(int userSeq) {
		return awardsMapper.removeAwardsByUserSeq(userSeq);
	}

	
	

}
