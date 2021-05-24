package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.FileInfoDto;
import com.ssafy.happyhouse.model.SearchDto;

@Mapper
public interface BoardMapper {
	List<BoardDto> list(SearchDto searchDto);

	BoardDto search(int bnum);

	int create(BoardDto boardDto);

	int modify(BoardDto boardDto);

	void deleteComment(int bnum);

	int delete(int bnum);
	
	public void fileRegist(BoardDto boardDto) throws SQLException;
	
	public FileInfoDto fileInfoList(int bnum);
	
}
