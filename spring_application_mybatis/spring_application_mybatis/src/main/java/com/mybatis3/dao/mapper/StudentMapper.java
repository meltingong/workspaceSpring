package com.mybatis3.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.mybatis3.domain.Student;
@Mapper
public interface StudentMapper {
	/*
	 * 인터페이스의 풀네임은 StudentMapper.xml의 namespace와일치
	 * StudentMapper 인터페이스와 같은 위치에 StudentMapper.xml을 위치시킨다.
	 * 메쏘드이름은 	StudentMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 StudentMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 StudentMapper.xml 파일의 resultType 와일치(ResultSet이 1개이상일경우는 List)
	 */
	
	public Student findStudentById(Integer studId);
	
	public List<Student> findAllStudents();
	
	public String findStudentNameById(Integer studId);
	
	public List<String> findStudentNameList();
	
	public int insertStudent(Student student);
	
	public int insertStudentBySequence1(Student student);
	@SelectKey(	statement = "select students_stud_id_seq.nextval from dual",
			before = true,
			keyProperty ="studId",
			resultType = Integer.class)
	@Insert("insert into students(stud_id,name,email,dob) values (#{student.studId},#{student.name},#{student.email},#{student.dob})")
	public int insertStudentBySequence2(@Param("student") Student student);
	
	public int updateStudentById(Student student);
	
	public int deleteStudentById(Integer StudId);
	
	public int deleteStudentByNameLike(String name);

	public Student findStudentByIdWithAddress(Integer studId);
	@ResultMap("studentWithCoursesResultMap")
	@Select("select s.stud_id,s.name as student_name,email,dob,\r\n"
			+ "			c.course_id,c.name as course_name,description,start_date,end_date \r\n"
			+ "			from students s \r\n"
			+ "			join course_enrollment ce\r\n"
			+ "			on s.stud_id = ce.stud_id\r\n"
			+ "			join courses c\r\n"
			+ "			on ce.course_id=c.course_id where s.stud_id=#{studId}")
	public Student findStudentByIdWithCourses(@Param("studId") Integer studId);
	
}
