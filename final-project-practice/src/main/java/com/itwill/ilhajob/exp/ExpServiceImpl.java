package com.itwill.ilhajob.exp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ExpServiceImpl implements ExpService{

	@Autowired
	private ExpDao expDao;
	
	public ExpServiceImpl() {
		
	}
	
	public ExpDao getExpDao() {
		return expDao;
	}

	public void setExpDao(ExpDao expDao) {
		this.expDao = expDao;
	}

	@Override
	public List<Exp> selectByUserSeq(int userSeq) {
		List<Exp> expList = expDao.selectByUser(userSeq);
		return expList;
	}
	
	/*
	@Override
	public List<Exp> selectByUserEmail(String userEmail) {
		List<Exp> expList = expDao.selectByUserEmail(userEmail);
		return expList;
	}
	*/
	
	@Override
	public int insertExp(Exp exp) {
		int insertCount = expDao.insertExp(exp);
		return insertCount;
	}

	@Override
	public int updateExp(Exp exp) {
		int updateCount = expDao.updateExp(exp);
		return updateCount;
	}

	@Override
	public int deleteExp(int expSeq) {
		int deleteCount = expDao.deleteExp(expSeq);
		return deleteCount;
	}

	
	
}
