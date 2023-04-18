package com.springboot.security.oauth.common.entity;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.springboot.security.oauth.common.utils.BeanUtils;
import com.springboot.security.oauth.user.entity.Message;
import com.springboot.security.oauth.user.repository.MessageRepository;


public class AppEntityListener {
	
	@Transactional
	@PostPersist
	public void prePersistAndPreUpdate(Object o) {
		System.out.println("######################prePersistAndPreUpdate##########################");
		MessageRepository messageRepository = BeanUtils.getBean(MessageRepository.class);
		App apply = (App) o;
		Message applyMessage = new Message();
		
		applyMessage.setMessageTitle("지원알림");
		applyMessage.setMessageContents(apply.getAppStatus() + " 지원알림");
		applyMessage.setMessageDate(LocalDateTime.now());
		applyMessage.setUser(apply.getUser());
		applyMessage = messageRepository.save(applyMessage);
		//messageRepository.count();
		System.out.println("prePersistAndPreUpdate 호출 : " + o);
		System.out.println("messageRepository.save : " + applyMessage);
	}
}
