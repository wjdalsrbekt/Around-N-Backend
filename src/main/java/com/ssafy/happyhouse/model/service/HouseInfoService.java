package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.HouseInfoDto;

public interface HouseInfoService {

	List<HouseInfoDto> list();

	HouseInfoDto apt_search(String AptName);

	HouseInfoDto dong_search(String dong);

	boolean create(HouseInfoDto houseInfoDto);

	boolean modify(HouseInfoDto houseInfoDto);

	boolean delete(int no);
}
