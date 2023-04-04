package com.itwill.ilhajob.corpimage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.corp.Corp;
import com.itwill.ilhajob.corpimage.CorpImage;

@Mapper
public interface CorpImageMapper {
	public int insertCorpImage(CorpImage corpImage);
	public CorpImage selectBySEQ(int corpImageSeq);
	public List<CorpImage> selectById(String corpId);
	public List<CorpImage> selectAll();
	public int updateCorpImage(CorpImage corpImage);
	public int deleteCorpImageById(String corpId);
	public int deleteCorpImageBySEQ(int corpImageSeq);
}
