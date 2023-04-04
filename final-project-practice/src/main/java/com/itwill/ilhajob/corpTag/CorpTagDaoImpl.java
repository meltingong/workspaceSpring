package com.itwill.ilhajob.corpTag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.corpTag.mapper.CorpTagMapper;
@Repository
public class CorpTagDaoImpl implements CorpTagDao{
	@Autowired
	CorpTagMapper corpTagMapper;
	
	@Override
	public int insertCorpTag(CorpTag corpTag) {
		return corpTagMapper.insertCorpTag(corpTag);
	}

	@Override
	public List<String> selectCorpByTag(int tagId) {
		return corpTagMapper.selectCorpByTag(tagId);
	}

	@Override
	public int deleteCorpTag(String corpId,int tagId) {
		return corpTagMapper.deleteCorpTag(CorpTag.builder().corpId(corpId).tagId(tagId).build());
	}

	@Override
	public boolean existedCorpTag(String corpId,int tagId) {
		if(corpTagMapper.existedCorpTag(CorpTag.builder().corpId(corpId).tagId(tagId).build())==1){
			return true;
		}else {
			return false;
		}
	}

}
