package com.itwill.ilhajob.message;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.message.mapper.MessageMapper;

@Repository
public class MessageDaoImpl implements MessageDao{
	@Autowired
	private MessageMapper messageMapper;

	@Override
	public Message findMessage(int messageSeq) {
		return messageMapper.findMessage(messageSeq);
	}

	@Override
	public int createMessage(Message message) {
		return messageMapper.createMessage(message);
	}

	@Override
	public int updateMessage(Message message) {
		return messageMapper.updateMessage(message);
	}

	@Override
	public int removeMessageBySeq(int messageSeq) {
		return messageMapper.removeMessageBySeq(messageSeq);
	}

	@Override
	public int removeMessageByUserSeq(int userSeq) {
		return messageMapper.removeMessageByUserSeq(userSeq);
	}

	@Override
	public List<Message> findMessageList() {
		return messageMapper.findMessageList();
	}

	@Override
	public List<Message> findMessageOfUser(int userSeq) {
		return messageMapper.findMessageOfUser(userSeq);
	}

}
