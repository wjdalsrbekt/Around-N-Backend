package com.ssafy.happyhouse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value ="TempviewDto : houseinfo 와 housedeal",description ="집의 매물 정보를 알려준다.")
public class TempviewDto {
	@ApiModelProperty(value="집 동")
	private String dong;
	@ApiModelProperty(value="아파트 이름")
	private String AptName;
	@ApiModelProperty(value="코드")
	private String code;
	@ApiModelProperty(value="건축년도")
	private String buildYear;
	@ApiModelProperty(value="경도")
	private String lat;
	@ApiModelProperty(value="위도")
	private String lng;
	@ApiModelProperty(value="총 금액")
	private String dealAmount;
	@ApiModelProperty(value="거래년도")
	private String dealYear;
	@ApiModelProperty(value="거래월")
	private String dealMonth;
	@ApiModelProperty(value="거래일")
	private String dealDay;
	@ApiModelProperty(value="면적")
	private String area;
	@ApiModelProperty(value="층수")
	private String floor;
	
	public TempviewDto(String dong, String aptName, String code, String buildYear, String lat, String lng,
			String dealAmount, String dealYear, String dealMonth, String dealDay, String area, String floor) {
		this.dong = dong;
		AptName = aptName;
		this.code = code;
		this.buildYear = buildYear;
		this.lat = lat;
		this.lng = lng;
		this.dealAmount = dealAmount;
		this.dealYear = dealYear;
		this.dealMonth = dealMonth;
		this.dealDay = dealDay;
		this.area = area;
		this.floor = floor;
	}

	@Override
	public String toString() {
		return "TempviewDto [dong=" + dong + ", AptName=" + AptName + ", code=" + code + ", buildYear=" + buildYear
				+ ", lat=" + lat + ", lng=" + lng + ", dealAmount=" + dealAmount + ", dealYear=" + dealYear
				+ ", dealMonth=" + dealMonth + ", dealDay=" + dealDay + ", area=" + area + ", floor=" + floor + "]";
	}

	public TempviewDto() {
	}

	public String getDong() {
		return dong;
	}

	public void setDong(String dong) {
		this.dong = dong;
	}

	public String getAptName() {
		return AptName;
	}

	public void setAptName(String aptName) {
		AptName = aptName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(String buildYear) {
		this.buildYear = buildYear;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public String getDealYear() {
		return dealYear;
	}

	public void setDealYear(String dealYear) {
		this.dealYear = dealYear;
	}

	public String getDealMonth() {
		return dealMonth;
	}

	public void setDealMonth(String dealMonth) {
		this.dealMonth = dealMonth;
	}

	public String getDealDay() {
		return dealDay;
	}

	public void setDealDay(String dealDay) {
		this.dealDay = dealDay;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	
}
