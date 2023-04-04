package com.itwill.ilhajob.exp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.exp.mapper.ExpMapper;

@Repository
public class ExpDaoImpl implements ExpDao {
	@Autowired
	private ExpMapper expMapper;
	
	public ExpDaoImpl(ExpMapper expMapper) {
		this.expMapper = expMapper;
	}

	public ExpDaoImpl() {

	}
	
	public ExpMapper getExpMapper() {
		return expMapper;
	}
	
	public void setExpMapper(ExpMapper expMapper) {
		this.expMapper = expMapper;
	}
	
	/*
	 * 경력 전체보기 (admin 없어서 필요없을 것 같음)
	 
	 public List<Exp> selectAll(){
		 List<Exp> expList = expMapper.selectAll();
		 return expList;
	 }
	*/

	/*
	 * 경력 seq로 경력사항 찾기(필요없을 듯)
	 * 
		public Exp selectByExpSeq(int expSeq) {
			Exp findExp = expMapper.selectByExp(expSeq);
			return findExp;
		}
	 * 
	 */
	
	
	 /*
	  * 한 유저의 경력 전체보기(userSeq로 찾기)
	  */
	 
	 public List<Exp> selectByUser(int userSeq){
		 List<Exp> expList = expMapper.selectByUser(userSeq);
		 return expList;
	 }
	 
	 /*
	  * 한 유저의 경력 전체보기
	  * 유저 이메일로 찾기 하려면 exp가 유저객체를 가져야함 추후에 필요하다면 논의필요
	 
		@Override
		public List<Exp> selectByUserEmail(String userEmail) {
			List<Exp> expList = expMapper.selectByUserEmail(userEmail);
			return expList;
		}
	  */
	 
	 /*
	  * 경력 추가
	  */
	 
	public int insertExp(Exp exp) {
		int insertExpCount = expMapper.insertExp(exp);
		return insertExpCount;
	}
	 
	/*
	 * 경력 수정
	 */
	public int updateExp(Exp exp) {
		int updateExpCount = expMapper.updateExp(exp);
		return updateExpCount;
	}
	
	/*
	 * 경력 삭제
	 */
	public int deleteExp(int expSeq) {
		int deleteCount = expMapper.deleteExp(expSeq);
		return deleteCount;
	}



}
