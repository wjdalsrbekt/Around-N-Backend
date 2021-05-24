package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.FileInfoDto;
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
		System.out.println(boardDto);
		int tmp = boardMapper.create(boardDto);
		System.out.println(boardDto);
		if (boardDto.getFileInfos() != null) {
			boardDto.getFileInfos().setBnum(boardDto.getBnum());
			boardMapper.fileRegist(boardDto.getFileInfos());
		}
		return tmp == 1;
//		return boardMapper.create(boardDto) == 1;
	}

	@Override
	public boolean modify(BoardDto boardDto) throws SQLException {
		int tmp = boardMapper.modify(boardDto);
		System.out.println(boardDto);
		FileInfoDto temp = new FileInfoDto();
		temp = boardMapper.fileInfoList(boardDto.getBnum());
		System.out.println(temp);
		if (boardDto.getFileInfos() != null) {
			FileInfoDto temp2 = boardDto.getFileInfos();
			if (temp2 != null&&temp!=null) { //기존 사진이 있을 때,
				temp.setOriginFile(temp2.getOriginFile());
				temp.setSaveFile(temp2.getSaveFile());
				temp.setSaveFolder(temp2.getSaveFolder());
				boardMapper.updateFile(temp);
			} else { // 기존 사진이 없으면서 사진이 수정될때
				boardDto.getFileInfos().setBnum(boardDto.getBnum());
				boardMapper.fileRegist(boardDto.getFileInfos());
			}
		}
//			boardMapper.updateFile(boardMapper.fileInfoList(boardDto.getBnum()));
		return tmp == 1;
	}

	@Override
	@Transactional
	public boolean delete(int bnum) {
		boardMapper.deleteComment(bnum);
		boardMapper.deleteFile(bnum);
		return boardMapper.delete(bnum) == 1;
	}

	@Override
	public FileInfoDto fileInfoList(int bnum) {
		return boardMapper.fileInfoList(bnum);
	}

}
