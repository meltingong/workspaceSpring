package com.itwill.ilhajob.tag.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.ilhajob.tag.Tag;

@Mapper
public interface TagMapper {
	public int insertTag(Tag tag);
	
	public Tag selectTagById(Integer tagId);
	
	public Tag selectTagByName(String tagName);
	
	public List<Tag> selectAllTag();
	
	public int updateTag(Tag tag);
	
	public int deleteTag(Integer tagId);
}
