package com.itwill.ilhajob.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.common.entity.App;
import com.itwill.ilhajob.corp.entity.Corp;
import com.itwill.ilhajob.corp.entity.Recruit;

@Repository
public interface AppRepository extends JpaRepository<App, Long> {
/*	
	Long countByCorpId(long id);
	Long countByCorp(Corp corp);
*/
	Long countByRecruitId(long id);
	//
	List<App> findAppsByRecruitId(long id);
	List<App> findAppsByCvId(long id);
	
}
