package com.itwill.ilhajob.blogheart.mapper;

import org.apache.ibatis.annotations.Param;


public interface BlogHeartMapper {

	public int insertHeart(@Param("blogSeq")int blogSeq,@Param("userSeq")int userSeq);
	
	public int deleteHeart(@Param("blogSeq")int blogSeq,@Param("userSeq")int userSeq);

	public int HeartCheck(@Param("blogSeq")int blogSeq,@Param("userSeq")int userSeq);

	public int updateHeartCheck(@Param("blogSeq")int blogSeq,@Param("userSeq")int userSeq);

	public int updateHeartCheckCancel(@Param("blogSeq")int blogSeq,@Param("userSeq")int userSeq);

	

}
