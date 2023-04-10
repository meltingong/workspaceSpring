package com.itwill.ilhajob.corp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.corp.entity.Recruit;

@Repository
public interface RecruitRepository extends JpaRepository<Recruit, Long>{

}
