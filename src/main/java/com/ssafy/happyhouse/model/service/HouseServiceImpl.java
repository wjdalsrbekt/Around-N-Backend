package com.ssafy.happyhouse.model.service;

import java.util.List;

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
	public List<HouseInfoDto> list(SearchDto searchDto) {
		return houseInfoMapper.list(searchDto);
	}

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
