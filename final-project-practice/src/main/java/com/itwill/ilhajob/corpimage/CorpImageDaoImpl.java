package com.itwill.ilhajob.corpimage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.corpimage.mapper.CorpImageMapper;

import lombok.RequiredArgsConstructor;

@Repository
public class CorpImageDaoImpl implements CorpImageDao {
	@Autowired
	private CorpImageMapper corpImageMapper;
	//회사이미지 1개 추가
	@Override
	public int insertCorpImage(CorpImage corpImage) {
		return corpImageMapper.insertCorpImage(corpImage);
	}
	//회사 이미지 1개 선택 
	@Override
	public CorpImage selectBySEQ(int corpImageSeq){
		return corpImageMapper.selectBySEQ(corpImageSeq);
	}
	//회사 이미지리스트 선택
	@Override
	public List<CorpImage> selectById(String corpId){
		return corpImageMapper.selectById(corpId);
	}
	//전 회사 이미지리스트 선택
	@Override
	public List<CorpImage> selectAll(){
		return corpImageMapper.selectAll();
	}
	//회사이미지 수정
	@Override
	public int updateCorpImage(CorpImage corpImage){
		return corpImageMapper.updateCorpImage(corpImage);
	}
	//회사이미지 계정삭제
	@Override
	public int deleteCorpImageById(String corpId){
		return corpImageMapper.deleteCorpImageById(corpId);
	}
	//회사이미지 1개 삭제
	@Override
	public int deleteCorpImageBySEQ(int corpImageSeq){
		return corpImageMapper.deleteCorpImageBySEQ(corpImageSeq);
	}
}
