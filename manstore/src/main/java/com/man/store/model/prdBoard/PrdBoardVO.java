package com.man.store.model.prdBoard;

import java.sql.Date;

public class PrdBoardVO {
	
	private int prd_b_num;				// 상품글번호
	private String prd_id;				// 상품번호
	private String b_content;			// 글내용
	private int admin_num;				// 작성자
	private Date b_regdate;				// 판매등록일
	private String menu_id;				// 소속메뉴
	private int b_like;					// 좋아요갯수
	private String b_title;				// 글제목
	private int reply_cnt;				// 댓글갯수
	private String prd_b_img;			// 사용이미지
	
	// join
	private String prd_name;			// 상품이름
	private int prd_price;				// 상품가격
	private int stock;					// 재고
	private String prd_option;			// 상품옵션
	private String prd_img;				// 상품 대표사진
	
	@Override
	public String toString() {
		return "[[ProductBoardVO] prd_b_num: " + prd_b_num 
						+ ", prd_id: " + prd_id 
						+ ", b_content: " + b_content 
						+ ", admin_num: " + admin_num 
						+ ", b_regdate: " + b_regdate 
						+ ", menu_id: " + menu_id 
						+ ", b_like: " + b_like 
						+ ", b_title: " + b_title 
						+ ", reply_cnt: " + reply_cnt
						+ ", prd_b_img: " + prd_b_img
						+ " ]";
	}
	
	public String getPrd_img() {
		return prd_img;
	}

	public void setPrd_img(String prd_img) {
		this.prd_img = prd_img;
	}

	public String getPrd_option() {
		return prd_option;
	}
	
	public void setPrd_option(String prd_option) {
		this.prd_option = prd_option;
	}
	
	public int getPrd_b_num() {
		return prd_b_num;
	}

	public void setPrd_b_num(int prd_b_num) {
		this.prd_b_num = prd_b_num;
	}

	public String getPrd_id() {
		return prd_id;
	}

	public void setPrd_id(String prd_id) {
		this.prd_id = prd_id;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public int getAdmin_num() {
		return admin_num;
	}

	public void setAdmin_num(int admin_num) {
		this.admin_num = admin_num;
	}

	public Date getB_regdate() {
		return b_regdate;
	}

	public void setB_regdate(Date b_regdate) {
		this.b_regdate = b_regdate;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	public int getB_like() {
		return b_like;
	}

	public void setB_like(int b_like) {
		this.b_like = b_like;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public int getReply_cnt() {
		return reply_cnt;
	}

	public void setReply_cnt(int reply_cnt) {
		this.reply_cnt = reply_cnt;
	}

	public String getPrd_b_img() {
		return prd_b_img;
	}

	public void setPrd_b_img(String prd_b_img) {
		this.prd_b_img = prd_b_img;
	}

	public String getPrd_name() {
		return prd_name;
	}

	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}

	public int getPrd_price() {
		return prd_price;
	}

	public void setPrd_price(int prd_price) {
		this.prd_price = prd_price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
