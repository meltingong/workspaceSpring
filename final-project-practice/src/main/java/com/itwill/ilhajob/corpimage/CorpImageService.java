package com.itwill.ilhajob.corpimage;

import java.util.List;

import org.springframework.stereotype.Service;


public interface CorpImageService {
	public int insertCorpImage(CorpImage corpImage);
	
	public CorpImage selectBySEQ(int corpImageSeq);
	
	public List<CorpImage> selectById(String corpId);
	
	public List<CorpImage> selectAll();
	
	public int updateCorpImage(CorpImage corpImage);
	
	public int deleteCorpImageById(String corpId);
	
	public int deleteCorpImageBySEQ(int corpImageSeq);
}