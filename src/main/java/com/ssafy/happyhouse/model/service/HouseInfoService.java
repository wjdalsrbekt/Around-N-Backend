package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SearchDto;

public interface HouseInfoService {
	List<HouseInfoDto> list(SearchDto searchDto);

	boolean create(HouseInfoDto houseInfoDto);

	boolean modify(HouseInfoDto houseInfoDto);

	boolean delete(int no);
}
