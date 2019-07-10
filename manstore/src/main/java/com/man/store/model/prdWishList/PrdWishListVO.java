package com.man.store.model.prdWishList;

public class PrdWishListVO {

	private int user_num;				// 회원번호
	private String prd_id;				// 상품번호
	private int quantity;				// 구매수량
	private int wish_num;				// 위시리스트 번호
	private String select_opt;			// 선택옵션
	
	@Override
	public String toString() {
		return "[[PrdWishListVO] user_num: " + user_num 
						+ ", prd_id: " + prd_id 
						+ ", quantity: " + quantity 
						+ ", wish_num: " + wish_num 
						+ ", select_opt: " + select_opt 
						+ " ]";
	}

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public String getPrd_id() {
		return prd_id;
	}

	public void setPrd_id(String prd_id) {
		this.prd_id = prd_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getWish_num() {
		return wish_num;
	}

	public void setWish_num(int wish_num) {
		this.wish_num = wish_num;
	}

	public String getSelect_opt() {
		return select_opt;
	}

	public void setSelect_opt(String select_opt) {
		this.select_opt = select_opt;
	}
}
