package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SearchDto;

public interface HouseInfoService {

	List<HouseInfoDto> list();

	List<HouseInfoDto> apt_search(SearchDto searchDto);

//	List<HouseInfoDto> dong_search(String dong);

	boolean create(HouseInfoDto houseInfoDto);

	boolean modify(HouseInfoDto houseInfoDto);

	boolean delete(int no);
}
