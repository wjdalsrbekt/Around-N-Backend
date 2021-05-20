package com.ssafy.happyhouse.controller;

import java.util.List;
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

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SearchDto;
import com.ssafy.happyhouse.model.service.HouseInfoService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/houseinfo")
public class HouseInfoRestController {
	private static final Logger logger = LoggerFactory.getLogger(HouseInfoRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	HouseInfoService houseInfoService;

	@ApiOperation(value = "모든 집 정보를 반환한다.", response = List.class)
	@GetMapping
	public ResponseEntity<List<HouseInfoDto>> listHouseInfo() {
		logger.debug("listHouseInfo - 호출 하기");
		return new ResponseEntity<>(houseInfoService.list(), HttpStatus.OK);
	}

	@ApiOperation(value = "AptName 혹은 dong 에 해당하는 게시판의 정보를 반환한다.", response = List.class)
	@PostMapping("/search")
	public ResponseEntity<List<HouseInfoDto>> searchAptName(@PathVariable SearchDto searchDto) {
		logger.debug("searchAptName - 호출하기");
		return new ResponseEntity<>(houseInfoService.apt_search(searchDto), HttpStatus.OK);
	}

//	@ApiOperation(value = "dong에 해당하는 게시판의 정보를 반환한다.", response = HouseInfoDto.class)
//	@GetMapping("/dong/{dong}")
//	public ResponseEntity<List<HouseInfoDto>> searchdong(@PathVariable String dong) {
//		logger.debug("searchdong - 호출하기");
//		return new ResponseEntity<>(houseInfoService.dong_search(dong), HttpStatus.OK);
//	}

	@ApiOperation(value = "새로운 집 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> createHouseInfo(@RequestBody HouseInfoDto houseInfoDto) {
		logger.debug("createHouseInfo - 호출");
		if (houseInfoService.create(houseInfoDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "no에 해당하는 집 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("{no}")
	public ResponseEntity<String> modifyHouseInfo(@RequestBody HouseInfoDto houseInfoDto) {
		logger.debug("modifyHouseInfo - 호출");
		logger.debug("" + houseInfoDto);
		if (houseInfoService.modify(houseInfoDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "no에 해당하는 집 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{no}")
	public ResponseEntity<String> deleteHouseInfo(@PathVariable("no") int no) {
		logger.debug("deleteBoard - 호출");
		if (houseInfoService.delete(no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
