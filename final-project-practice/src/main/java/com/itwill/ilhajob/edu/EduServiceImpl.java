package com.itwill.ilhajob.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EduServiceImpl implements EduService {
	
	@Autowired
	private EduDao eduDao;
	
	public EduServiceImpl(EduDao eduDao) {
		this.eduDao = eduDao;
	}

	@Override
	public int insertEdu(Edu edu) {
		return eduDao.insertEdu(edu);
	}

	@Override
	public List<Edu> selectEduByUserSeq(int userSeq) {
		return eduDao.selectEduByUserSeq(userSeq);
	}

	@Override
	public List<Edu> selectAllEdu() {
		return eduDao.selectAllEdu();
	}
	
	@Override
	public int updateEdu(Edu edu) {
		return eduDao.updateEdu(edu);
	}

	@Override
	public int deleteEduByEduSeq(int eduSeq) {
		return eduDao.deleteEduByEduSeq(eduSeq);
	}

	@Override
	public int deleteAllEdu(int userSeq) {
		return eduDao.deleteAllEdu(userSeq);
	}
	
}
