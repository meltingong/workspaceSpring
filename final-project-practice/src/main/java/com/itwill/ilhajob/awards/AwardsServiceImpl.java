package com.itwill.ilhajob.awards;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AwardsServiceImpl implements AwardsService {
	
	@Autowired
	private AwardsDao awardsDao;
	
	public AwardsServiceImpl(AwardsDao awardsDao) {
		this.awardsDao=awardsDao;
	}
	

	@Override
	public int createAwards(Awards awards) {
		int insertCount = awardsDao.createAwards(awards);
		return insertCount;
	}

	@Override
	public int updateAwards(Awards awards) {
		int updateCount = awardsDao.updateAwards(awards);
		return updateCount;
	}

	@Override
	public int removeAwardsBySeq(int awardsSeq) {
		int removeAwards = awardsDao.removeAwardsBySeq(awardsSeq);
		return removeAwards;
	}

	@Override
	public Awards findAwards(int awardsSeq) {
		Awards findAwardsSeq = awardsDao.findAwards(awardsSeq);
		return findAwardsSeq;
	}

	@Override
	public List<Awards> findAwardsList() {
		List<Awards> awaList = awardsDao.findAwardsList();
		return awaList;
	}
	
	//회원seq로 해당 수상실적 찾기
	@Override
	public List<Awards> findAwardsOfUser(int userSeq) {
		List<Awards> findAwardsByUser = awardsDao.findAwardsOfUser(userSeq);
		return findAwardsByUser;
	}

	//회원seq로 수상실적 삭제
	@Override
	public int removeAwardsByUserSeq(int userSeq) {
		return awardsDao.removeAwardsByUserSeq(userSeq);
	}

}
