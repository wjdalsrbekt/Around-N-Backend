package com.ssafy.happyhouse.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.UserDto;

@Mapper
public interface UserMapper {
	public UserDto login(Map<String,String> map);
	
	public UserDto find(String userid);
	
	public int findUser(String userid);
	
	public int join(UserDto userdto);
	
	public int userModify(UserDto userdto);
	
	public int userDelete(String userid);
}
