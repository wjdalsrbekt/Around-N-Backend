package com.ssafy.happyhouse.model.service;

import java.util.Map;

import com.ssafy.happyhouse.model.UserDto;

public interface UserService {
	UserDto login(Map<String,String> map);
	
	boolean findUser(String userid);
	
	boolean join(UserDto userdto);
	
	boolean userModify(UserDto userdto);
	
	boolean userDelete(String userid);
}
