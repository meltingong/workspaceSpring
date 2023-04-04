package com.itwill.ilhajob.edu;

import java.util.List;

public interface EduDao {
    int insertEdu(Edu edu);
    List<Edu> selectEduByUserSeq(int userSeq);
    List<Edu> selectAllEdu();
    int updateEdu(Edu edu);
    int deleteEduByEduSeq(int eduSeq);
    int deleteAllEdu(int userSeq);
}
