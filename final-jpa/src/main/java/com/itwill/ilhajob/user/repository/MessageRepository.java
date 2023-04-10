package com.itwill.ilhajob.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.ilhajob.user.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
