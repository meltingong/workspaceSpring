package com.itwill.ilhajob.manager;

import java.util.List;

public interface ManagerDao {
	
	//manager 생성
	int insert(Manager manager) throws Exception;
	
	//기존 manager 수정
	int update(Manager manager) throws Exception;
	
	//기존 manager 삭제
	int delete(String managerEmail) throws Exception;
	
	//managerEmail로 기존 manager 1명 정보 불러오기
	Manager findManager(String managerEmail) throws Exception;
	
	//managerEmail로 기존 manager 존재 여부 판별
	boolean existManager(String managerEmail) throws Exception;
	
	//corpId로 해당되는 매니저 모두 불러오기-corp mapper에서 실시
	//List<Manager> listManagerByCorpId(String corpId) throws Exception;

}