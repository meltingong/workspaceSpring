package com.mybatis3.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mybatis3.domain.Tutor;
@Mapper
public interface TutorMapper {
	@ResultMap("tutorWithCoursesResultMap")
	@Select("select t.tutor_id,t.name as tutor_name,email,\r\n"
			+ "			 		course_id,c.name as course_name,description,\r\n"
			+ "			 		start_date,end_date\r\n"
			+ "			from tutors t  \r\n"
			+ "			join courses c \r\n"
			+ "			on t.tutor_id = c.tutor_id \r\n"
			+ "			where t.tutor_id=#{tutorId}")
	public Tutor findTutorByIdWithCourses(@Param("tutorId") Integer tutorId);
	
}
