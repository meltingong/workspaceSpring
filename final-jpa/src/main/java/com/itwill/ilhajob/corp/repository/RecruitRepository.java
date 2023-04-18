package com.itwill.ilhajob.corp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.corp.entity.Recruit;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit, Long>{
	//corpId(Long id)로 recruit List 불러오기
	List<Recruit> findByCorpId(Long id);
	
	//corpId(Long id)로 현재활성화중인 공고갯수 불러오기
	Long countByCorpId(Long id);
	
	
	
}

