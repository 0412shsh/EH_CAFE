package com.ehcafe.domain;

import java.sql.Date;

public class BoardVO {

	private int board_num;
	private String category;
	private String user_id;
	private String title;
	private String content;
	private Date write_date;
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	@Override
	public String toString() {
		return "BoardVO [board_num=" + board_num + ", category=" + category + ", user_id=" + user_id + ", title="
				+ title + ", content=" + content + ", write_date=" + write_date + "]";
	}
	
	
	
	

	
}
