package com.itwill.ilhajob.corpimage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorpImageServiceImpl implements CorpImageService{
	@Autowired
	CorpImageDao corpImageDao;

	@Override
	public int insertCorpImage(CorpImage corpImage) {
		return corpImageDao.insertCorpImage(corpImage);
	}

	@Override
	public CorpImage selectBySEQ(int corpImageSeq) {
		return corpImageDao.selectBySEQ(corpImageSeq);
	}

	@Override
	public List<CorpImage> selectById(String corpId) {
		return corpImageDao.selectById(corpId);
	}

	@Override
	public List<CorpImage> selectAll() {
		return corpImageDao.selectAll();
	}

	@Override
	public int updateCorpImage(CorpImage corpImage) {
		return corpImageDao.updateCorpImage(corpImage);
	}

	@Override
	public int deleteCorpImageById(String corpId) {
		return corpImageDao.deleteCorpImageById(corpId);
	}

	@Override
	public int deleteCorpImageBySEQ(int corpImageSeq) {
		return corpImageDao.deleteCorpImageBySEQ(corpImageSeq);
	}
	
	
}
