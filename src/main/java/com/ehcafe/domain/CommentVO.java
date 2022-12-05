package com.ehcafe.domain;

import java.sql.Date;

public class CommentVO {

	
	private int reply_num;
	private int board_num;
	private String user_id;
	private String comment;
	private Date reply_date;
	private Date reply_updatedate;
	
	public int getReply_num() {
		return reply_num;
	}
	public void setReply_num(int reply_num) {
		this.reply_num = reply_num;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getReply_date() {
		return reply_date;
	}
	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}
	public Date getReply_updatedate() {
		return reply_updatedate;
	}
	public void setReply_updatedate(Date reply_updatedate) {
		this.reply_updatedate = reply_updatedate;
	}
	
	@Override
	public String toString() {
		return "CommentVO [reply_num=" + reply_num + ", board_num=" + board_num + ", user_id=" + user_id + ", comment="
				+ comment + ", reply_date=" + reply_date + ", reply_updatedate=" + reply_updatedate + "]";
	}
	
	
}
