package com.itwill.ilhajob.message.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.message.Message;

@Mapper
public interface MessageMapper {
	
	public Message findMessage(int messageSeq);
	
	public int createMessage(Message message);
	
	public int updateMessage(Message message);
	
	public int removeMessageBySeq(int messageSeq);
	
	public int removeMessageByUserSeq(int userSeq);
	
	public List<Message> findMessageList();
	
	public List<Message> findMessageOfUser(int userSeq);
}
