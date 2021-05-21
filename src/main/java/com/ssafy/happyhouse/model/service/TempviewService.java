package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.SearchDto;
import com.ssafy.happyhouse.model.TempviewDto;

public interface TempviewService {
	List<TempviewDto> list(SearchDto searchDto);
}
