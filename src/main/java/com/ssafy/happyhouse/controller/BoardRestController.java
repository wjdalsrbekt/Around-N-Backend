package com.ssafy.happyhouse.controller;

import java.util.List;

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

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.SearchDto;
import com.ssafy.happyhouse.model.service.BoardService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/board")
public class BoardRestController {
	private static final Logger logger = LoggerFactory.getLogger(BoardRestController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	BoardService boardService;

	@ApiOperation(value = "모든 게시판의 정보를 반환한다.", response = List.class)
	@PostMapping("/list")
	public ResponseEntity<List<BoardDto>> listBoard(@RequestBody SearchDto searchDto) {
//		System.out.println("들어옴: "+searchDto.getKey() );
//		System.out.println("들어옴: "+searchDto.getWord());
//		System.out.println(boardService.list(searchDto));
		logger.debug("listBoard - 호출 하기");
		return new ResponseEntity<>(boardService.list(searchDto), HttpStatus.OK);
	}

	@ApiOperation(value = "bnum에 해당하는 게시판의 정보를 반환한다.", response = BoardDto.class)
	@GetMapping("/{bnum}")
	public ResponseEntity<BoardDto> searchBoard(@PathVariable int bnum) {
		logger.debug("searchBoard - 호출하기");
		return new ResponseEntity<>(boardService.search(bnum), HttpStatus.OK);
	}

	@ApiOperation(value = "새로운 게시판 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> createBoard(@RequestBody BoardDto boardDto) {
		logger.debug("createBoard - 호출");
		if (boardService.create(boardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "bnum에 해당하는 게시판의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyBoard(@RequestBody BoardDto boardDto) {
		logger.debug("modifyBoard - 호출");
		logger.debug("" + boardDto);
//		System.out.println(boardDto);
		if (boardService.modify(boardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "bnum에 해당하는 게시판의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("{bnum}")
	public ResponseEntity<String> deleteBoard(@PathVariable("bnum") int bnum) {
		logger.debug("deleteBoard - 호출");
		if (boardService.delete(bnum)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
}
