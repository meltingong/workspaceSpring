package com.itwill.ilhajob.recruitTag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecruitTagServiceImpl implements RecruitTagService{
	@Autowired
	RecruitTagDao recruitTagDao;
	
	@Override
	public int insertRecruitTag(RecruitTag recruitTag) {
		//중복 태그 유효성검사
		if(recruitTagDao.existedRecruitTag(recruitTag.getRcSeq(),
											recruitTag.getTagId())) {
			return 0;
		}
		return recruitTagDao.insertRecruitTag(recruitTag);
	}

	@Override
	public List<String> selectRecruitByTag(int tagId) {
		return recruitTagDao.selectRecruitByTag(tagId);
	}

	@Override
	public int deleteRecruitTag(int rcSeq, int tagId) {
		return recruitTagDao.deleteRecruitTag(rcSeq, tagId);
	}

}
