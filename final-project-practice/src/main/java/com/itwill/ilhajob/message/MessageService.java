package com.itwill.ilhajob.message;

import java.util.List;

public interface MessageService {
	
	int createMessage(Message message);
	int updateMessage(Message message);
	int removeMessageBySeq(int messageSeq);
	int removeMessageByUserSeq(int userSeq);
	Message findMessageDetail(int messageSeq);
	List<Message> findMessageList();
	List<Message> fineMessageOfUser(int userSeq);
	
	
}
