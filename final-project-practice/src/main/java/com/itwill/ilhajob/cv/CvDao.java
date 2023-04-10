package com.itwill.ilhajob.cv;

import java.util.List;

public interface CvDao {
	
	Cv selectByCv(int cvSeq);
	
	List<Cv> selectAll();
	
	List<Cv> findCvListByUserSeq(int userSeq);
	
	//List<Cv> findCvOfUser(String userEmail);
	
	Cv detailCv(int cvSeq);
	
	int createCv(Cv cv);
	
	int updateCv(Cv cv);
	
	int remove(int cvSeq);
	
	//한 회사가 올린 공고 하나의 이력서 목록 불러오기
	//List<Cv> findCvListByCorpId(String corpId);

}
