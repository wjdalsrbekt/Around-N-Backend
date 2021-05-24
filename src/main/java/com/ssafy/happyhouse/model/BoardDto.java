package com.ssafy.happyhouse.model;

import java.util.List;

import com.ssafy.happyhouse.model.FileInfoDto;

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
	@ApiModelProperty(value = "상세정보")
	private String content;
	@ApiModelProperty(value="파일올리기")
	private FileInfoDto fileInfos;
	

	public BoardDto() {
	}

	public FileInfoDto getFileInfos() {
		return fileInfos;
	}

	public void setFileInfos(FileInfoDto fileInfos) {
		this.fileInfos = fileInfos;
	}

	@Override
	public String toString() {
		return "BoardDto [bnum=" + bnum + ", title=" + title + ", userid=" + userid + ", price=" + price + ", regdate="
				+ regdate + ", content=" + content + ", fileInfos=" + fileInfos + "]";
	}

	public BoardDto(int bnum, String title, String userid, int price, String regdate, String content,
			FileInfoDto fileInfos) {
		super();
		this.bnum = bnum;
		this.title = title;
		this.userid = userid;
		this.price = price;
		this.regdate = regdate;
		this.content = content;
		this.fileInfos = fileInfos;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

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
