package com.ssafy.happyhouse.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SearchDto;
import com.ssafy.happyhouse.model.mapper.HouseInfoMapper;

@Service
public class HouseServiceImpl implements HouseInfoService {

	@Autowired
	private HouseInfoMapper houseInfoMapper;

	@Override
	public List<HouseInfoDto> list() {
		return houseInfoMapper.list();
	}

	@Override
	public List<HouseInfoDto> apt_search(SearchDto searchDto) {
		return houseInfoMapper.apt_search(searchDto);
	}

//	@Override
//	public List<HouseInfoDto> dong_search(String dong) {
//		return houseInfoMapper.dong_search(dong);
//	}

	@Override
	public boolean create(HouseInfoDto houseInfoDto) {
		return houseInfoMapper.create(houseInfoDto) == 1;
	}

	@Override
	public boolean modify(HouseInfoDto houseInfoDto) {
		return houseInfoMapper.modify(houseInfoDto) == 1;
	}

	@Override
	@Transactional
	public boolean delete(int no) {
		return houseInfoMapper.delete(no) == 1;
	}

}
