package com.springboot.security.oauth.common.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.security.oauth.common.entity.App;

@Repository
public interface AppRepository extends JpaRepository<App, Long> {
/*	
	Long countByCorpId(long id);
	Long countByCorp(Corp corp);
*/
	Long countByRecruitId(long id);
	//기업대쉬보드에서 사용
	List<App> findAppsByRecruitId(long id);
	//유저대쉬보드에서 사용
	List<App> findAppsByUserId(long id);
	
	List<App> findAppsByCvId(long id);
	
}
