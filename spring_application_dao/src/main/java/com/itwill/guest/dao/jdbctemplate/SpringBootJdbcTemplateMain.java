package com.itwill.guest.dao.jdbctemplate;

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootJdbcTemplateMain {

	public static void main(String[] args) throws Exception {
		ApplicationContext applicationContext = SpringApplication.run(SpringBootJdbcTemplateMain.class, args);
		JdbcTemplate jdbcTemplate = (JdbcTemplate)applicationContext.getBean(JdbcTemplate.class);
		System.out.println("1.JdbcTemplate:"+jdbcTemplate);
		System.out.println("2.JdbcTemplate DataSource:"+jdbcTemplate.getDataSource());
		System.out.println("1.JdbcTemplate DataSource Connection:"+jdbcTemplate.getDataSource().getConnection());
				
		System.out.println("1.JdbcTemplate객체 얻기");
		/*
		 * SELECT-->queryForObject 반환타입[String,Wrapper,DTO]
		 */
		/*
		 * queryForObject([반환타입 DTO])
		 */
		String selectDtoSql = "select * from guest where guest_no =?";
		Object[] paramArray1 = {1};
		Object[] paramArray2 = new Object[]{1};
		
		/*
		 * <BeanPropertyRowMapper 클래스>
		 * 	ResultSet객체로부터 데이터를 컬럼이름으로 get해서 
		 * 	Guest객체 생성 후 테이블컬럼이름과 동일한 이름의 Guest객체의 set property(멤버변수)에 대입
		 */
		BeanPropertyRowMapper<Guest> guestBeanPropertyRowMapper = new BeanPropertyRowMapper<Guest>(Guest.class);
		
		
		Guest guest = jdbcTemplate.queryForObject(selectDtoSql,
													new Object[]{1},
													new int[] {Types.INTEGER},
													guestBeanPropertyRowMapper);
		System.out.println("quaryForObject[Guest]:"+guest);
		/*
		 * queryForObject([반환타입 String Wrapper])
		 */
		String selectStringSql = "select guest_name from guest where guest_no=?";
		String guest_name = jdbcTemplate.queryForObject(selectStringSql, new Object[]{69},new int[] {Types.INTEGER} ,String.class);
		System.out.println("queryForObject[String]:"+guest_name);
		
		
		/*
		 * SELECT-->query 반환타입[List<Guest,User>]
		 */
		/*
		 * querry[반환타입 List<Guest>]
		 */
		String selectDtoListSql = "select * from guest";
		List<Guest> guestList = jdbcTemplate.query(selectDtoListSql,guestBeanPropertyRowMapper);
		System.out.println("query[List<Guest>]:"+guestList);
		
		
		/*
		 * SELECT --> queryForList 반환타입[List<String,Wrapper>]
		 */
		String selectStringListSql = "select guest_name from guest"; 
		List<String> guest_nameList = jdbcTemplate.queryForList(selectStringListSql,String.class);
		System.out.println("--> queryForList[List<String>]:"+guest_nameList);
		
		/*
		 * SELECT --> queryForMap 반환타입[List<Map<String,Object>>]
		 */
		String selectMapSql = "select * from guest where guest_no=?";
		Map rowMap = jdbcTemplate.queryForMap(selectMapSql,new Object[]{1},new int[] {Types.INTEGER});
		System.out.println("--> queryForMap 반환타입[Map<String,Object>]:"+rowMap);
		
		String selectMapListSql = "select * from guest";
		List rowMapList = jdbcTemplate.queryForList(selectMapListSql);
		System.out.println("--> queryForMap 반환타입[List<Map<String,Object>>]:"+rowMapList);
		
		
		/*
		 * DML(update,delete,insert) --> update 반환타입[rowCount(int)]
		 */
	
		String insertSql="insert into guest values(guest_no_seq.nextval,?,sysdate,?,?,?,?)";
		int rowCount = jdbcTemplate.update(insertSql,"김수미","sumi@gamil.com","www.sumi.com","수미네반찬가게","아아아아악");
		System.out.println("insert rowCount:"+rowCount);
		String updateSql="update guest set  guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no=?";
		rowCount = jdbcTemplate.update(updateSql,"김숫미","sutmi@gamil.com","www.sutmi.com","숫미네반찬가게","아아아ㅏ아ㅏㄱ",88);
		System.out.println("update rowCount:"+rowCount);
		String deleteSql="delete from guest where guest_no=?";
		rowCount = jdbcTemplate.update(deleteSql,88);
		System.out.println("delete rowCount:"+rowCount);
		
	}

}
