package com.itwill.ilhajob.tag;

import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public interface TagDao{
	public int insertTag(Tag tag);
	
	public Tag selectTagById(int tagId);
	
	public Tag selectTagByName(String tagName);
	
	public List<Tag> selectAllTag();
	
	public int updateTag(Tag tag);
	
	public int deleteTag(int tagId);
}
