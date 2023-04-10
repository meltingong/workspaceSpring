package com.itwill.ilhajob.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.common.entity.App;

@Repository
public interface AppRepository extends JpaRepository<App, Long> {
	
	Long countByCorpId(String corpId);
}
