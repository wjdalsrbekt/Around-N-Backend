package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.SearchDto;
import com.ssafy.happyhouse.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardDto> list(SearchDto searchDto) {
		return boardMapper.list(searchDto);
	}

	@Override
	public BoardDto search(int bnum) {
		return boardMapper.search(bnum);
	}

	@Override
	@Transactional
	public boolean create(BoardDto boardDto) throws SQLException {
		int tmp=boardMapper.create(boardDto);
		if(boardDto.getFileInfos()!=null)
			boardMapper.fileRegist(boardDto);
		return tmp==1;
//		return boardMapper.create(boardDto) == 1;
	}

	@Override
	public boolean modify(BoardDto boardDto) {
		return boardMapper.modify(boardDto) == 1;
	}

	@Override
	@Transactional
	public boolean delete(int bnum) {
		boardMapper.deleteComment(bnum);
		return boardMapper.delete(bnum) == 1;
	}

}
