package com.itwill.ilhajob.manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.manager.Manager;

@Mapper
public interface ManagerMapper {
	
	public int insertManager(Manager manager);
	
	public int updateManager(Manager manager);
	
	public int deleteManager(String managerEmail);
	
	public Manager findManagerByEmail(String managerEmail);
	
	public int existedManager(String managerEmail);
	
	//corp mapper에서 실시
	//public List<Manager> selectListByCorpId(String corpId);
}
