package com.ssafy.happyhouse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "HouseInfoDto : 집 정보", description = "집의 상세정보를 나타낸다.")
public class HouseInfoDto {
	@ApiModelProperty(value = "집 등록번호")
	private int no;
	@ApiModelProperty(value = "집 주소 동")
	private String dong;
	@ApiModelProperty(value = "아파트 이름")
	private String AptName;
	@ApiModelProperty(value = "코드")
	private String code;
	@ApiModelProperty(value = "건축년도")
	private String buildYear;
	@ApiModelProperty(value = "번지수")
	private String jibun;
	@ApiModelProperty(value = "위도")
	private String lat;
	@ApiModelProperty(value = "경도")
	private String lng;
	@ApiModelProperty(value = "이미지")
	private String img;

	public HouseInfoDto() {
	}

	@Override
	public String toString() {
		return "houseInfoDto [no=" + no + ", dong=" + dong + ", AptName=" + AptName + ", code=" + code + ", buildYear="
				+ buildYear + ", jibun=" + jibun + ", lat=" + lat + ", lng=" + lng + ", img=" + img + "]";
	}

	public HouseInfoDto(int no, String dong, String aptName, String code, String buildYear, String jibun, String lat,
			String lng, String img) {
		super();
		this.no = no;
		this.dong = dong;
		AptName = aptName;
		this.code = code;
		this.buildYear = buildYear;
		this.jibun = jibun;
		this.lat = lat;
		this.lng = lng;
		this.img = img;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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

	public String getJibun() {
		return jibun;
	}

	public void setJibun(String jibun) {
		this.jibun = jibun;
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
