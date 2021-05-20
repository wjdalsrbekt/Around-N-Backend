package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SearchDto;

public interface HouseInfoMapper {
	List<HouseInfoDto> list(SearchDto searchDto);

	int create(HouseInfoDto houseInfoDto);

	int modify(HouseInfoDto houseInfo);

	int delete(int no);

}
