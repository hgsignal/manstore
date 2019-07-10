package com.man.store.model.product;

import java.sql.Date;

public class ProductVO {
	
	private Date prd_date;			// 상품등록일
	private String prd_name;		// 상품이름
	private String prd_id;			// 상품번호
	private int prd_price;			// 상품가격
	private String prd_img;			// 상품사진
	private int prd_delivery;		// 배송비
	private int stock;				// 재고
	private String prd_option;		// 상품옵션
	private int discount;			// 상품할인금액
	private String prd_color;		// 상품색상
	private int prd_sales;			// 판매량

	@Override
	public String toString() {
		return "[[ProductVO] prd_date: " + prd_date 
						+ ", prd_name: " + prd_name 
						+ ", prd_id: " + prd_id 
						+ ", prd_price: " + prd_price 
						+ ", prd_img: " + prd_img 
						+ ", prd_delivery: " + prd_delivery 
						+ ", stock: " + stock 
						+ ", prd_option: " + prd_option 
						+ ", discount: " + discount 
						+ ", prd_color: " + prd_color 
						+ ", prd_sales: " + prd_sales 
						+ " ]";
	}

	public Date getPrd_date() {
		return prd_date;
	}

	public void setPrd_date(Date prd_date) {
		this.prd_date = prd_date;
	}

	public String getPrd_name() {
		return prd_name;
	}

	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}

	public String getPrd_id() {
		return prd_id;
	}

	public void setPrd_id(String prd_id) {
		this.prd_id = prd_id;
	}

	public int getPrd_price() {
		return prd_price;
	}

	public void setPrd_price(int prd_price) {
		this.prd_price = prd_price;
	}

	public String getPrd_img() {
		return prd_img;
	}

	public void setPrd_img(String prd_img) {
		this.prd_img = prd_img;
	}

	public int getPrd_delivery() {
		return prd_delivery;
	}

	public void setPrd_delivery(int prd_delivery) {
		this.prd_delivery = prd_delivery;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getPrd_option() {
		return prd_option;
	}

	public void setPrd_option(String prd_option) {
		this.prd_option = prd_option;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getPrd_color() {
		return prd_color;
	}

	public void setPrd_color(String prd_color) {
		this.prd_color = prd_color;
	}

	public int getPrd_sales() {
		return prd_sales;
	}

	public void setPrd_sales(int prd_sales) {
		this.prd_sales = prd_sales;
	}
	
}
