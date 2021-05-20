package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.SearchDto;

public interface BoardService {
	List<BoardDto> list(SearchDto searchDto);

	BoardDto search(int bnum);

	boolean create(BoardDto boardDto);

	boolean modify(BoardDto boardDto);

	boolean delete(int bnum);
}
