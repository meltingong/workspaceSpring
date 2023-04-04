package com.itwill.ilhajob.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.user.User;

@Mapper
public interface UserMapper {
	
	public int create(User user);

	public int update(User user);

	public int remove(String userEmail);

	public User findUser(String userEmail);

	public int existedUser(String userEmail);
	
	public int findBySnsId(String snsType, String snsId);
	
	public User findExpAwardsEduByUserSeq(int userSeq);
	
	public User findAppByUserSeq(int userSeq);
	
	public User findUserByIdWithReview(int userSeq);
	
}