package com.ehcafe.domain;

import java.sql.Date;

public class MemberVO {

	private String user_id;
	private String user_name;
	private String user_email;
	private String user_pw;
	private String user_phone;
	private Date reg_date;
	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "MemberVO [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email + ", user_pw="
				+ user_pw + ", user_phone=" + user_phone + ", reg_date=" + reg_date + "]";
	}

	
	

}
