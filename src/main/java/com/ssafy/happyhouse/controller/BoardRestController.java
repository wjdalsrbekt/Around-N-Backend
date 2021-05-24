package com.ssafy.happyhouse.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.FileInfoDto;
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
	ServletContext servletContext;
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

	///////////////////////////////////
//	@ApiOperation(value = "새로운 게시판 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
//	@PostMapping
//	public ResponseEntity<String> createBoard(@RequestBody BoardDto boardDto) throws SQLException {
//		logger.debug("createBoard - 호출");
//		if (boardService.create(boardDto)) {
//			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
//		}
//		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
//	}

/////////////////////////////////////////
	// @RequestMapping(value = "/write", method = RequestMethod.POST)
	@ApiOperation(value = "새로운 게시판 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> createBoard(BoardDto boardDto, @RequestParam(value="upfile", required = false) MultipartFile files)
			throws IllegalStateException, IOException {
		System.out.println("wrfiteController" + boardDto);
		if (files != null && !files.isEmpty()) {
//			String realPath = servletContext.getRealPath("/resources/img");
			String realPath = servletContext.getRealPath("/upload");
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			String saveFolder = realPath + File.separator + today;
			File folder = new File(saveFolder);
			if (!folder.exists()) {
				System.out.println("####");
				folder.mkdirs();
			}
			List<FileInfoDto> fileInfos = new ArrayList<FileInfoDto>();
			FileInfoDto fileInfoDto = new FileInfoDto();
			String originalFileName = files.getOriginalFilename();
			if (!originalFileName.isEmpty()) {
				String saveFileName = UUID.randomUUID().toString()
						+ originalFileName.substring(originalFileName.lastIndexOf('.'));
				fileInfoDto.setSaveFolder(today);
				fileInfoDto.setOriginFile(originalFileName);
				fileInfoDto.setSaveFile(saveFileName);
				files.transferTo(new File(folder, saveFileName));
			}
			fileInfos.add(fileInfoDto);
			boardDto.setFileInfos(fileInfos);
		}
		try {
			boardService.create(boardDto);
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
//			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
	}

	/////////////////////////
	@ApiOperation(value = "bnum에 해당하는 게시판의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyBoard(@RequestBody BoardDto boardDto) {
		logger.debug("modifyBoard - 호출");
		logger.debug("" + boardDto);
		System.out.println(boardDto);
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

//	@GetMapping("/download/{bnum}")
//	public ResponseEntity<FileInfoDto> downloadFile(@RequestParam("sfolder") String sfolder, @RequestParam("ofile") String ofile,
//			@RequestParam("sfile") String sfile) {
////		Map<String, Object> fileInfo = new HashMap<String, Object>();
////		fileInfo.put("sfolder", sfolder);
////		fileInfo.put("ofile", ofile);
////		fileInfo.put("sfile", sfile);
//		FileInfoDto fileInfoDto=new FileInfoDto();
//		fileInfoDto.setSaveFolder(sfolder);
//		fileInfoDto.setOriginFile(ofile);
//		fileInfoDto.setSaveFile(sfile);
//		return new ResponseEntity<FileInfoDto>(fileInfoDto,HttpStatus.OK);
//
//	}
	@GetMapping("/download/{bnum}")
	public ResponseEntity<FileInfoDto> downloadFile(@PathVariable("bnum")int bnum) {
		return new ResponseEntity<FileInfoDto>(boardService.fileInfoList(bnum),HttpStatus.OK);
	}
}
