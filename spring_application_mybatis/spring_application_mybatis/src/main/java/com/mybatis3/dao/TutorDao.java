package com.mybatis3.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybatis3.dao.mapper.TutorMapper;

@Repository
public class TutorDao {
	@Autowired
	private TutorMapper tutorMapper;
	
	
}
