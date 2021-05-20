package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import com.ssafy.happyhouse.model.HouseInfoDto;

public interface HouseInfoMapper {
	List<HouseInfoDto> list();

	HouseInfoDto apt_search(String AptName);

	HouseInfoDto dong_search(String dong);

	int create(HouseInfoDto houseInfoDto);

	int modify(HouseInfoDto houseInfo);

	int delete(int no);

}
