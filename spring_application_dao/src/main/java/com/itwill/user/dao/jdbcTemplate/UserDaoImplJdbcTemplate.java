package com.itwill.user.dao.jdbcTemplate;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BeanPropertyBindingResult;

@Repository
public class UserDaoImplJdbcTemplate implements UserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int create(User user) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(UserSQL.USER_INSERT,user.getUserId(),user.getPassword(), user.getName(),user.getEmail());
	}

	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(UserSQL.USER_UPDATE,user.getUserId(),user.getPassword(),user.getName(),user.getEmail());
	}

	@Override
	public int remove(String userId) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(UserSQL.USER_REMOVE,userId);
	}

	@Override
	public User findUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(UserSQL.USER_SELECT_BY_ID, new Object[]{userId},new int[]{Types.VARCHAR},new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public List<User> findUserList() throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(UserSQL.USER_SELECT_ALL, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
}
