package com.itwill.ilhajob.corp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.ilhajob.corp.exception.CorpNotFoundException;
import com.itwill.ilhajob.corp.exception.ExistedCorpException;
import com.itwill.ilhajob.user.exception.PasswordMismatchException;



@Service
public class CorpServiceImpl implements CorpService{
	
	@Autowired
	private CorpDao corpDao;
	
	@Override
	public int create(Corp corp) throws ExistedCorpException, Exception {
		//1.아이디중복체크
		if(corpDao.existedCorp(corp.getCorpId())) {
			//아이디중복
			throw new ExistedCorpException(corp.getCorpId()+" 는 이미 존재하는 아이디입니다.");
		}
		//아이디안중복
		//2.회원가입
		return corpDao.insertCorp(corp);
	}
	/*
	 * 기업로그인
	 */
	@Override
	public int login(String corpId,String corpPassword) throws CorpNotFoundException, PasswordMismatchException, Exception {
		int result=1;
		//1.아이디 존재여부
		Corp corp = corpDao.selectById(corpId);
		if(corp==null) {
			//아이디존재안함
			throw new CorpNotFoundException(corpId+" 는 존재하지않는 아이디입니다.");
		}
		//아이디존재함
		if(!corp.isMatchPassword(corpPassword)){
			//패쓰워드불일치
			throw new PasswordMismatchException("패쓰워드가 일치하지 않습니다.");
		}
		return result; //성공 1
	}
	
	//기업 기본정보상세보기
	@Override
	public Corp findCorp(String corpId) throws Exception {
		return corpDao.selectById(corpId);
	}
	@Override
	public int update(Corp corp) throws Exception {
		return corpDao.updateCorp(corp);
	}
	@Override
	public int remove(String corpId) throws Exception {
		return corpDao.deleteCorp(corpId);
	}
	@Override
	public boolean isDuplicateId(String corpId) throws Exception {
		boolean isExist = corpDao.existedCorp(corpId);
		if(isExist) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public Corp findCorpWithimagesAndManagers(String corpId)  throws Exception{
		return corpDao.findCorpByIdWithAll(corpId);
	}
	@Override
	public Corp findCorpWithOrdersWithProduct(String corpId)  throws Exception{
		return corpDao.findCorpByIdWithOrders(corpId);
	}
	@Override
	public Corp findCorpWithRecruits(String corpId)  throws Exception{
		return corpDao.findCorpByIdWithRecruit(corpId);
	}
	@Override
	public Corp findCorpWithReviews(String corpId)  throws Exception{
		return corpDao.findCorpByIdWithReview(corpId);
	}
	@Override
	public List<Corp> findCorpAll() throws Exception {
		return corpDao.selectAll();
	}
	
}
