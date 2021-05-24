package com.ssafy.happyhouse.model;

public class FileInfoDto {

	private int bnum;
	private String saveFolder;
	private String originFile;
	private String saveFile;

	
	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getSaveFolder() {
		return saveFolder;
	}

	public void setSaveFolder(String saveFolder) {
		this.saveFolder = saveFolder;
	}

	public String getOriginFile() {
		return originFile;
	}

	public void setOriginFile(String originFile) {
		this.originFile = originFile;
	}

	public String getSaveFile() {
		return saveFile;
	}

	public void setSaveFile(String saveFile) {
		this.saveFile = saveFile;
	}

	@Override
	public String toString() {
		return "FileInfoDto [bnum=" + bnum + ", saveFolder=" + saveFolder + ", originFile=" + originFile + ", saveFile="
				+ saveFile + "]";
	}

	

}
