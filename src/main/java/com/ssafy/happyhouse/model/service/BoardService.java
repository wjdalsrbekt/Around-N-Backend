package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.FileInfoDto;
import com.ssafy.happyhouse.model.SearchDto;

public interface BoardService {
	List<BoardDto> list(SearchDto searchDto);

	BoardDto search(int bnum);

	boolean create(BoardDto boardDto) throws SQLException;

	boolean modify(BoardDto boardDto) throws SQLException;

	boolean delete(int bnum);
	
	FileInfoDto fileInfoList(int bnum);
	
	
}
