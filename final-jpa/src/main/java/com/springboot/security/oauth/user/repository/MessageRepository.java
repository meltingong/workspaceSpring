package com.springboot.security.oauth.user.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.security.oauth.user.entity.Message;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	/*
	 * 유저 알림 list 
	 */
	List<Message> findByUserId(Long id);
}
