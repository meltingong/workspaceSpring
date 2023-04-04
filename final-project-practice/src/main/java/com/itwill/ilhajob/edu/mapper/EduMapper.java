package com.itwill.ilhajob.edu.mapper;

import com.itwill.ilhajob.edu.Edu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EduMapper {

    public int insertEdu(Edu edu);
    public List<Edu> selectEduByUserSeq(int userSeq);
    public List<Edu> selectAllEdu();
    public int updateEdu(Edu edu);
    public int deleteEduByEduSeq(int eduSeq);
    public int deleteAllEdu(int userSeq);
}
