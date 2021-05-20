package com.ssafy.happyhouse.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins= {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/user")
public class UserRestController {
	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	private static final String SUCCESS ="success";
	private static final String FAIL = "fail";
	
	@Autowired
	UserService userService;
	
	@ApiOperation(value="유저는 로그인을 한다. 해당되는 유저정보를 반환한다.",response = String.class)
	@PostMapping("/login")
	public ResponseEntity<UserDto> loginUser(@RequestBody Map<String, String> map){
		logger.debug("loginUser - 호출");
		return new ResponseEntity<UserDto>(userService.login(map),HttpStatus.OK);
	}
	
	@ApiOperation(value="유저는 회원가입을 한다. DB입력 성공여부에 따라 'success'또는 'fail'문자열을 반환한다. ", response = String.class)
	@PostMapping("/join")
	public ResponseEntity<String> joinUser(@RequestBody UserDto userDto){
		logger.debug("joinUser - 호출");
		if(userService.join(userDto)) {
			return new ResponseEntity<String>(SUCCESS,HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	
	@ApiOperation(value="유저가 입력한 아이디가 이미 DB에 저장되어있으면 'fail', 가입가능한 아이디라면 'success'문자열을 반환한다.", response = String.class)
	@GetMapping("{userid}")
	public ResponseEntity<String> findUser(@PathVariable("userid") String userid){
		logger.debug("findUser - 호출");
		if(userService.findUser(userid)) {
			return new ResponseEntity<String>(SUCCESS,HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL,HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="아이디가 userid에 해당하는 회원정보를 수정한다. DB수정 성공여부에 따라 'success' 또는 'fail'문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyUser(@RequestBody UserDto userDto){
		logger.debug("modifyUser - 호출");
		if(userService.userModify(userDto)) {
			return new ResponseEntity<String>(SUCCESS,HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL,HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value="해당 id를 가진 정보를 삭제한다. DB삭제 성공여부에 따라 'success'또는 'fail'문자열을 반환한다.")
	@DeleteMapping("{userid}")
	public ResponseEntity<String> deleteUser(@PathVariable("userid") String userid){
		logger.debug("deleteUser - 호출");
		if(userService.userDelete(userid)) {
			return new ResponseEntity<String>(SUCCESS,HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL,HttpStatus.NO_CONTENT);
	}
	
}
