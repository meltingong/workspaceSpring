package com.itwill.ilhajob.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.itwill.ilhajob.user.exception.ExistedUserException;
import com.itwill.ilhajob.user.exception.PasswordMismatchException;
import com.itwill.ilhajob.user.exception.UserNotFoundException;


/*
 * - 회원관리 업무(비즈니스로직,예외처리,트랜젝션,보안,로깅)을 수행하는 클래스
 * - 웹컴포넌트(서블릿,JSP)에서 직접접근(메쏘드호출)하는 클래스(객체)
 * - Dao를 이용해서 데이타베이스를 조작작업(CRUD)하는 클래스
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public int create(User user) throws Exception {
		//1.아이디중복체크
		if(userDao.existedUser(user.getUserEmail()) || userDao.findBySnsId(user.getSnsType(),user.getSnsId())) {
			//아이디중복
			ExistedUserException exception=
					new ExistedUserException(user.getUserEmail()+" 는 이미 존재하는아이디입니다.");
			exception.setData(user);
			throw exception;
		}
		//아이디안중복
		//2.회원가입
		return userDao.create(user);
	}

	@Override
	public int login(String userEmail, String userPassword) throws Exception {
		int result=1;
		
		User user = userDao.findUser(userEmail);
		if(!userDao.existedUser(userEmail)) {
			UserNotFoundException exception = 
					new UserNotFoundException(userEmail+" 는 존재하지않는 아이디입니다.");
			exception.setData(user);
			throw exception;
		}
		if(!user.isMatchPassword(userPassword)){
			//패쓰워드불일치
			PasswordMismatchException exception=
				new PasswordMismatchException("패쓰워드가 일치하지않습니다.");
			throw exception;
		}
		return result;
	}

	@Override
	public User findUser(String userId) throws Exception {
		return userDao.findUser(userId);
	}

	@Override
	public int update(User user) throws Exception {
		return userDao.update(user);
	}

	@Override
	public int remove(String userId) throws Exception {
		return userDao.remove(userId);
	}

	@Override
	public boolean isDuplicateId(String userId) throws Exception {
		boolean isExist = userDao.existedUser(userId);
		if(isExist) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public User findAppList(int userSeq) throws Exception {
		return userDao.findAppList(userSeq);
	}

	
}
















