package com.itwill.ilhajob.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageDao messageDao;
	
	public MessageServiceImpl(MessageDao messageDao) {
		this.messageDao=messageDao;
	}
	
	@Override
	public int createMessage(Message message) {
		return messageDao.createMessage(message);
	}

	@Override
	public int updateMessage(Message message) {
		return messageDao.updateMessage(message);
	}

	@Override
	public int removeMessageBySeq(int messageSeq) {
		return messageDao.removeMessageBySeq(messageSeq);
	}

	@Override
	public int removeMessageByUserSeq(int userSeq) {
		return messageDao.removeMessageByUserSeq(userSeq);
	}

	@Override
	public Message findMessageDetail(int messageSeq) {
		return messageDao.findMessage(messageSeq);
	}

	@Override
	public List<Message> findMessageList() {
		return messageDao.findMessageList();
	}

	@Override
	public List<Message> fineMessageOfUser(int userSeq) {
		return messageDao.findMessageOfUser(userSeq);
	}

}
