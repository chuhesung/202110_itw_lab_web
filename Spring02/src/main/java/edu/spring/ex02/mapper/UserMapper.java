package edu.spring.ex02.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.spring.ex02.domain.User;

@Mapper // 스프링 컨테이너에서 컴포넌트 객체(java bean)로 생성해서 관리하도록.
public interface UserMapper {

	// 회원 가입
	String SIGN_UP = 
			"INSERT INTO ${TABLE_USERS} (${COL_USERID}, ${COL_PWD}, ${COL_EMAIL}) "
			+ "VALUES (#{userid}, #{pwd}, #{email})";
	
	@Insert(SIGN_UP)
	int insert(User user);
	
	// 중복 아이디 체크
	String CHECK_USER_ID = 
			"SELECT * FROM ${TABLE_USERS} WHERE ${COL_USERID} = #{userid}";
	
	@Select(CHECK_USER_ID)
	User selectByUserId(String userid);
	
}