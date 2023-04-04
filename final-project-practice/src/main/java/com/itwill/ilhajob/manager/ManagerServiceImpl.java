package com.itwill.ilhajob.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private ManagerDao managerDao;
	
	//constructor
    public ManagerServiceImpl(ManagerDao managerDao) {
    	this.managerDao=managerDao;
	}
    
    //getter
	public ManagerDao getManagerDao() {
		return managerDao;
	}
	
	//setter
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	
	//update manager
	@Override
	public int updateManager(Manager manager) throws Exception {
		return managerDao.update(manager);
	}
	
	//delete manager
	@Override
	public int deleteManager(String managerEmail) throws Exception {
		return managerDao.delete(managerEmail);
	}
	
	//managerEmail로 매니저 1명의 정보 불러오기
	@Override
	public Manager findManagerByEmail(String managerEmail) throws Exception {
		return managerDao.findManager(managerEmail);
	}
	
	/* corp mapper에서 실시
	//cropId에 해당하는 매니저 리스트 불러오기
	@Override
	public List<Manager> selectListByCorpId(String corpId) throws Exception {
		return managerDao.listManagerByCorpId(corpId);
	}
	*/
	
	//ManagerEmail 중복 여부 체크->이것도 User처럼 회원가입 안할거라 필요 없을 것 같기도...
	@Override
	public boolean existedManager(String managerEmail) throws Exception {
		boolean isExist=managerDao.existManager(managerEmail);
		if(isExist) {
			return true;
		}else {
			return false;
		}
	}
	
	//manager insert/create: user처럼 manager는 회원가입 및 유효성체크할 필요 없다고 함...
	@Override
	public int insertManager(Manager manager) throws Exception {
		return managerDao.insert(manager);
	}
	
}
