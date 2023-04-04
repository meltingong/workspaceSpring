package com.itwill.ilhajob.exp;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ExpDao {
	
	int insertExp(Exp exp);
	
	List<Exp> selectByUser(int userSeq);
	
	//List<Exp> selectByUserEmail(String userEmail);
	
	//List<Exp> selectAll();
	
	int updateExp(Exp exp);
	
	int deleteExp(int expSeq);
	
}
