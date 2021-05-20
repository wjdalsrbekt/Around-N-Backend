package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.BoardDto;

public interface BoardService {
	List<BoardDto> list();

	BoardDto search(int bnum);

	boolean create(BoardDto boardDto);

	boolean modify(BoardDto boardDto);

	boolean delete(int bnum);
}
