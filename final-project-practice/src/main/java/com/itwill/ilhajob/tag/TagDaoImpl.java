package com.itwill.ilhajob.tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.ilhajob.tag.mapper.TagMapper;

@Repository
public class TagDaoImpl implements TagDao{
	@Autowired
	TagMapper tagMapper;
	
	@Override
	public int insertTag(Tag tag) {
		return tagMapper.insertTag(tag);
	}

	@Override
	public Tag selectTagById(int tagId) {
		return tagMapper.selectTagById(tagId);
	}

	@Override
	public Tag selectTagByName(String tagName) {
		return tagMapper.selectTagByName(tagName);
	}

	@Override
	public List<Tag> selectAllTag() {
		return tagMapper.selectAllTag();
	}

	@Override
	public int updateTag(Tag tag) {
		return tagMapper.updateTag(tag);
	}

	@Override
	public int deleteTag(int tagId) {
		return tagMapper.deleteTag(tagId);
	}

}
