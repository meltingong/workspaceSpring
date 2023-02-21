package com.itwill.guest;

import java.util.List;

public class GuestServiceImpl implements GuestService {
	
	public GuestServiceImpl() {
		System.out.println("1.#### GuestServiceImpl() 기본생성자");
	}
	
	@Override
	public List<Guest> selectAll()throws Exception{
		System.out.println("#### GuestServiceImpl : selectAll() 호출");
		return  null;
	}
	@Override
	public Guest selectByNo(int no)throws Exception{
		System.out.println("#### GuestServiceImpl : selectByNo(int no) 호출");
		return null;
	}
	@Override
	public int insertGuest(Guest guest)throws Exception{
		System.out.println("#### GuestServiceImpl : insertGuest(Guest guest) 호출");
		return 0;
	}
	@Override
	public int updateGuest(Guest guest)throws Exception{
		System.out.println("#### GuestServiceImpl : updateGuest(Guest guest) 호출");
		return 0;
	}
	@Override
	public int deleteGuest(int no)throws Exception{
		System.out.println("#### GuestServiceImpl : deleteGuest(int no) 호출");
		return 0;
	}
	
}
