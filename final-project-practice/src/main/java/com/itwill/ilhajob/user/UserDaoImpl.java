package com.itwill.ilhajob.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.user.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private UserMapper userMapper;

	public UserDaoImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override
	public int create(User user) throws Exception {
		return userMapper.create(user);
	}

	@Override
	public int update(User user) throws Exception {
		return userMapper.update(user);
	}

	@Override
	public int remove(String userId) throws Exception {
		return userMapper.remove(userId);
	}

	@Override
	public User findUser(String userId) throws Exception {
		return userMapper.findUser(userId);
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		if(userMapper.existedUser(userId)==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean findBySnsId(String snsType, String snsId) throws Exception {
		if(userMapper.findBySnsId(snsType,snsId)==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public User findExpAwardsEduList(int userSeq) throws Exception {
		return userMapper.findExpAwardsEduByUserSeq(userSeq);
	}

	@Override
	public User findAppList(int userSeq) throws Exception {
		return userMapper.findAppByUserSeq(userSeq);
	}

	@Override
	public User findUserByIdWithReview(int userSeq) throws Exception {
		return userMapper.findUserByIdWithReview(userSeq);
	}

	

}