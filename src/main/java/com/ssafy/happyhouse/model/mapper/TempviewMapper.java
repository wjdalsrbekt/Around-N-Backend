package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import com.ssafy.happyhouse.model.SearchDto;
import com.ssafy.happyhouse.model.TempviewDto;

public interface TempviewMapper {
	List<TempviewDto> list(SearchDto searchDto);
}
