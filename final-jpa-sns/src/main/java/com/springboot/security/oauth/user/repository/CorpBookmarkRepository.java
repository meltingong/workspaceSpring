package com.springboot.security.oauth.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.security.oauth.user.entity.CorpBookmark;


public interface CorpBookmarkRepository extends JpaRepository<CorpBookmark, Long> {

}
