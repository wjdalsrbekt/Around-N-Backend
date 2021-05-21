package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.SearchDto;
import com.ssafy.happyhouse.model.TempviewDto;
import com.ssafy.happyhouse.model.service.TempviewService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/tempview")
public class TempviewRestController {
	private static final Logger logger = LoggerFactory.getLogger(HouseInfoRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	TempviewService tempviewService;

	@ApiOperation(value = "모든 집 정보 및 상세검색 한 것을 반환한다. ", response = List.class)
	@PostMapping("/list")
	public ResponseEntity<List<TempviewDto>> listTempview(@RequestBody SearchDto searchDto) {
		logger.debug("listTempInfo - 호출하기");
//		System.out.println(tempviewService.list(searchDto));
		return new ResponseEntity<List<TempviewDto>>(tempviewService.list(searchDto),HttpStatus.OK);
	}
}
