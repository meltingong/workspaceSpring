package com.itwill.ilhajob.cv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.itwill.ilhajob.cv.Cv;

@Mapper
public interface CvMapper {
	
	public Cv selectByCv(int cvSeq);
	
	public List<Cv> selectAll();
	
	//public List<Cv> selectByCvOfUserEmail(String userEmail);
	
	public List<Cv> selectByCvOfUserSeq(int userSeq);
	
	// 이력서 상세보기
	public Cv selectDetailCv(int cvSeq);
	
	public int insertCv(Cv cv);
	
	public int updateCv(Cv cv);
	
	public int deleteCv(int cvSeq);
}
