package com.man.store.model.member;

import java.sql.Date;

public class UserVO {
	private int user_num;		// 회원번호
	private String user_id;		// 회원아이디
	private String user_name;	// 회원이름
	private String user_pwd;	// 회원비밀번호
	private Date user_birth;	// 회원생일
	private String email;		// 회원이메일
	private int zipcode;		// 회원우편번호
	private String address1;	// 회원주소
	private String address2;	// 회원상세주소
	private String phone;		// 회원전화번호
	private Date user_regdate;	// 회원가입일
	private String interest;	// 회원관심분야
	private String user_div;	// 사용자구분

	@Override
	public String toString() {
		return "[[UserVO] user_num: " + user_num 
						+ ", user_id: " + user_id 
						+ ", user_name: " + user_name 
						+ ", user_pwd: " + user_pwd 
						+ ", user_birth: " + user_birth 
						+ ", email: " + email 
						+ ", zipcode: " + zipcode 
						+ ", address1: " + address1 
						+ ", address2: " + address2
						+ ", phone: " + phone 
						+ ", user_regdate: " + user_regdate
						+ ", interest: " + interest 
						+ ", user_div: " + user_div + " ]";
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

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

	public String getUser_pwd() {
		return user_pwd;
	}

	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}

	public Date getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(Date user_birth) {
		this.user_birth = user_birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getUser_regdate() {
		return user_regdate;
	}

	public void setUser_regdate(Date user_regdate) {
		this.user_regdate = user_regdate;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getUser_div() {
		return user_div;
	}

	public void setUser_div(String user_div) {
		this.user_div = user_div;
	}

}
