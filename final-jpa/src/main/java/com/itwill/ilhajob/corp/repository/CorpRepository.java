package com.itwill.ilhajob.corp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.corp.entity.Corp;

@Repository
public interface CorpRepository extends JpaRepository<Corp, Long> {
	
    Optional<Corp> findByCorpLoginId(String corpLoginId);
    boolean existsByCorpLoginId(String corpLoginId);
}
