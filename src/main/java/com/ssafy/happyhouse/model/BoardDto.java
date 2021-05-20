package com.ssafy.happyhouse.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BoardDto : 게시판 정보", description = "게시판의 상세정보를 나타낸다.")
public class BoardDto {
	@ApiModelProperty(value = "게시판 번호")
	private int bnum;
	@ApiModelProperty(value = "게시판 제목")
	private String title;
	@ApiModelProperty(value = "게시판 저자")
	private String userid;
	@ApiModelProperty(value = "집 가격")
	private int price;
	@ApiModelProperty(value = "작성시각")
	private String regdate;

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public BoardDto(int bnum, String title, String userid, int price, String regdate, String content) {
		super();
		this.bnum = bnum;
		this.title = title;
		this.userid = userid;
		this.price = price;
		this.regdate = regdate;
		this.content = content;
	}

	@ApiModelProperty(value = "상세정보")
	private String content;

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
