package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.CommentDto;
import com.ssafy.happyhouse.model.mapper.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public List<CommentDto> list(int bnum) {
		return commentMapper.list(bnum);
	}

	@Override
	public boolean create(CommentDto commentDto) {
		return commentMapper.create(commentDto)==1;
	}

	@Override
	public boolean modify(CommentDto commentDto) {
		return commentMapper.modify(commentDto)==1;
	}

	@Override
	public boolean delete(int comment_no) {
		return commentMapper.delete(comment_no)==1;
	}

}
