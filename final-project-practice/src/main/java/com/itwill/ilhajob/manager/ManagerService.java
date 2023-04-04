package com.itwill.ilhajob.manager;

import java.util.List;

public interface ManagerService {

	//insert manager
	int insertManager(Manager manager) throws Exception;
	
	//update manager
	int updateManager(Manager manager)throws Exception;
	
	//delete manager
	int deleteManager(String managerEmail) throws Exception;
	
	//email로 매니저 1명 정보 불러오기
	Manager findManagerByEmail(String managerEmail) throws Exception;
	
	//email로 기존 DB에 매니저 존재 여부 확인
	boolean existedManager(String managerEmail) throws Exception;
	
	//corp_id로 해당되는 매니저 리스트 불러오기-corp mapper에서 실시
	//List<Manager> selectListByCorpId(String corpId) throws Exception;
	
	
}