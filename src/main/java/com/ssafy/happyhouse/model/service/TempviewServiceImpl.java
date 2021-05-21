package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.SearchDto;
import com.ssafy.happyhouse.model.TempviewDto;
import com.ssafy.happyhouse.model.mapper.TempviewMapper;

@Service
public class TempviewServiceImpl implements TempviewService{

	@Autowired
	private TempviewMapper tempviewMapper;
	
	@Override
	public List<TempviewDto> list(SearchDto searchDto) {
		return tempviewMapper.list(searchDto);
	}
	
}
