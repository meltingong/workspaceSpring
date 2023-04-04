package com.itwill.ilhajob.awards.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.awards.Awards;

@Mapper
public interface AwardsMapper {
	
		public Awards selectByAwards(int awardsSeq);
		
		public int insertAwards(Awards awards);
		
		public int updateAwards(Awards awards);
		
		public int removeAwardsBySeq(int awardsSeq);
		
		public int removeAwardsByUserSeq(int userSeq);
		
		public List<Awards> selectAll();
		
		public List<Awards> selectByAwardsOfUser(int userSeq);

}
