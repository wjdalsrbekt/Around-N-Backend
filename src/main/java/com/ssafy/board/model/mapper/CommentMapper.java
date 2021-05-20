package com.ssafy.board.model.mapper;

import java.util.List;

import com.ssafy.board.model.CommentDto;

public interface CommentMapper {
	List<CommentDto> list(int bnum);

	int create(CommentDto commentDto);

	int modify(CommentDto commentDto);

	int delete(int comment_no);
}
