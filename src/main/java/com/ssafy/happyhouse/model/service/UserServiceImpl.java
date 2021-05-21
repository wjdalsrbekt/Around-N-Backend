package com.ssafy.happyhouse.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	@Override
	public UserDto login(Map<String, String> map) {
		return userMapper.login(map);
	}

	@Override
	public boolean join(UserDto userdto) {
		return userMapper.join(userdto)==1;
	}

	@Override
	public boolean userModify(UserDto userdto) {
		return userMapper.userModify(userdto)==1;
	}

	
	@Override
	@Transactional
	public boolean userDelete(String userid) {
		return userMapper.userDelete(userid)==1;
	}

	@Override
	public boolean findUser(String userid) {
		return userMapper.findUser(userid)==0;
	}

	@Override
	public UserDto find(String userid) {
		return userMapper.find(userid);
	}

}
