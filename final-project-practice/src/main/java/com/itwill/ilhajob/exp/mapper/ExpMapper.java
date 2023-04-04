package com.itwill.ilhajob.exp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.exp.Exp;
@Mapper
public interface ExpMapper {
	
	//public List<Exp> selectAll(); admin 없어서 필요없을 듯
	
	//public Exp selectByExp(int expSeq); 경력seq로 찾을 일이 없을듯
	
	public List<Exp> selectByUser(int userSeq);
	
	List<Exp> selectByUserEmail(String userEmail);
	
	public int insertExp(Exp exp);
	
	public int updateExp(Exp exp);
	
	public int deleteExp(int expSeq);
}
