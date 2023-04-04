package com.itwill.ilhajob.recruitTag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.recruitTag.mapper.RecruitTagMapper;

@Repository
public class RecruitTagDaoImpl implements RecruitTagDao{
	@Autowired
	RecruitTagMapper recruitTagMapper;
	
	@Override
	public int insertRecruitTag(RecruitTag recruitTag) {
		return recruitTagMapper.insertRecruitTag(recruitTag);
	}

	@Override
	public List<String> selectRecruitByTag(int tagId) {
		return recruitTagMapper.selectRecruitByTag(tagId);
	}

	@Override
	public int deleteRecruitTag(int rcSeq, int tagId) {
		return recruitTagMapper.deleteRecruitTag(RecruitTag.builder()
												.rcSeq(rcSeq)
												.tagId(tagId)
												.build());
	}

	@Override
	public boolean existedRecruitTag(int rcSeq, int tagId) {
		if(recruitTagMapper.existedRecruitTag(RecruitTag.builder()
												.rcSeq(rcSeq)
												.tagId(tagId).build())==1){
			return true;
		}else {
			return false;
		}
	}

}
