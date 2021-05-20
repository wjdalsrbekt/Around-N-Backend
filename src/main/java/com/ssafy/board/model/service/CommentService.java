package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.CommentDto;

public interface CommentService {
	List<CommentDto> list(int bnum);

	boolean create(CommentDto commentDto);

	boolean modify(CommentDto commentDto);

	boolean delete(int comment_no);
}
