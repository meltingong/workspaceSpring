package com.itwill.ilhajob.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.manager.mapper.ManagerMapper;

@Repository
public class ManagerDaoImpl implements ManagerDao{
	
	@Autowired
	private ManagerMapper managerMapper;

	@Override
	public int insert(Manager manager) throws Exception {
		return managerMapper.insertManager(manager);
	}

	@Override
	public int update(Manager manager) throws Exception {
		return managerMapper.updateManager(manager);
	}

	@Override
	public int delete(String managerEmail) throws Exception {
		return managerMapper.deleteManager(managerEmail);
	}

	@Override
	public Manager findManager(String managerEmail) throws Exception {
		return managerMapper.findManagerByEmail(managerEmail);
	}

	@Override
	public boolean existManager(String managerEmail) throws Exception {
		if(managerMapper.existedManager(managerEmail)==1) {
			return true;
		}else {
			return false;
		}
	}
	/* corp mapper에서 실시
	@Override
	public List<Manager> listManagerByCorpId(String corpId) throws Exception {
		return managerMapper.selectListByCorpId(corpId);
	}
	*/
	
	
}
