package com.itwill.guest.dao.mybatis;


import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GuestDaoImplMyBatis implements GuestDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Guest> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("com.itwill.guest.dao.mybatis.guestMapper.selectAll");
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("com.itwill.guest.dao.mybatis.guestMapper.selectByNo",no);
	}

	@Override
	public int insertGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert("com.itwill.guest.dao.mybatis.guestMapper.insertGuest",guest);
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update("com.itwill.guest.dao.mybatis.guestMapper.updateGuest",guest);
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete("com.itwill.guest.dao.mybatis.guestMapper.deleteGuest",no);
	}

	
	
}
