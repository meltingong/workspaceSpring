package com.itwill.ilhajob.message;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface MessageDao {
	
	Message findMessage(int messageSeq);
	
	int createMessage(Message message);
	
	int updateMessage(Message message);
	
	int removeMessageBySeq(int messageSeq);
	
	int removeMessageByUserSeq(int userSeq);
	
	List<Message> findMessageList();
	
	List<Message> findMessageOfUser(int userSeq);
}
