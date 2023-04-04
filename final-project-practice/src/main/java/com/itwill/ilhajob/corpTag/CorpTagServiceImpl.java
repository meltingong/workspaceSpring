package com.itwill.ilhajob.corpTag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorpTagServiceImpl implements CorpTagService{
	@Autowired
	CorpTagDao corpTagDao;

	@Override
	public int insertCorpTag(CorpTag corpTag) {
		if(corpTagDao.existedCorpTag(corpTag.getCorpId(),
				corpTag.getTagId())) {
			return 0;
		}
		return corpTagDao.insertCorpTag(corpTag);
	}

	@Override
	public List<String> selectCorpByTag(int tagId) {
		return corpTagDao.selectCorpByTag(tagId);
	}

	@Override
	public int deleteCorpTag(String corpId, int tagId) {
		return corpTagDao.deleteCorpTag(corpId, tagId);
	}


	
}
