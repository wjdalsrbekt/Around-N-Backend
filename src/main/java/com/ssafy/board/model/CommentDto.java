package com.ssafy.board.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CommentDto : 게시판 상세정보에 작성하는 댓글")
public class CommentDto {
	@ApiModelProperty(value = "글번호")
	private int comment_no;
	@ApiModelProperty(value = "작성자이름")
	private String user_name;
	@ApiModelProperty(value = "내용")
	private String comment_content;
	@ApiModelProperty(value = "작성시각")
	private String comment_time;
	@ApiModelProperty(value = "게시물고유번호")
	private int bnum;

	public int getComment_no() {
		return comment_no;
	}

	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
	}

	public String getComment_time() {
		return comment_time;
	}

	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

}
