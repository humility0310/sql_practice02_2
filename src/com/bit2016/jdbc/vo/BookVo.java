package com.bit2016.jdbc.vo;

public class BookVo {

	private Long no;
	private String title;
	private String pubData;
	private String state;
	private Long authorNo;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubData() {
		return pubData;
	}

	public void setPubData(String pubData) {
		this.pubData = pubData;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getAuthorNo() {
		return authorNo;
	}

	public void setAuthorNo(Long authorNo) {
		this.authorNo = authorNo;
	}

}
