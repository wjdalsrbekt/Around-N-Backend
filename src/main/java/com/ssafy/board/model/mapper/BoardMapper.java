package com.ssafy.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.board.model.BoardDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> list();

	BoardDto search(int bnum);
	
	int create(BoardDto boardDto);
	int modify(BoardDto boardDto);
	
	void deleteComment(int bnum);
	int delete(int bnum);
}
