package com.itwill.ilhajob.edu;

import com.itwill.ilhajob.edu.mapper.EduMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EduDaoImpl implements EduDao {
    @Autowired
    private EduMapper eduMapper;

    /****************  ****************/
    public EduDaoImpl(EduMapper eduMapper) {
    	this.eduMapper = eduMapper;
    }

    @Override
    public int insertEdu(Edu edu) {
        return eduMapper.insertEdu(edu);
    }

    @Override
    public List<Edu> selectEduByUserSeq(int userSeq) {
        return eduMapper.selectEduByUserSeq(userSeq);
    }

    @Override
    public List<Edu> selectAllEdu() {
        return eduMapper.selectAllEdu();
    }

    @Override
    public int updateEdu(Edu edu) {
        return eduMapper.updateEdu(edu);
    }

    /**************** eduSeq로 삭제(단일 삭제) ****************/
    @Override
    public int deleteEduByEduSeq(int eduSeq) {
        return eduMapper.deleteEduByEduSeq(eduSeq);
    }

    /********* userSeq로 삭제(user의 학력사항 전체 삭제) ********/
    @Override
    public int deleteAllEdu(int userSeq) {
        return eduMapper.deleteAllEdu(userSeq);
    }
}
