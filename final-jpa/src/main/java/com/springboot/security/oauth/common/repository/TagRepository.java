package com.springboot.security.oauth.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.security.oauth.common.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Long>{

}
