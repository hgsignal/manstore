package com.man.store.model.menu;

public class MenuVO {
	
	private String menu_id;				// 메뉴번호
	private String menu_title;			// 메뉴이름
	private String menu_parent;			// 메뉴부모
	private int menu_seq;				// 메뉴정렬순
	private String menu_visible;		// 메뉴사용여부
	
	@Override
	public String toString() {
		return "[[MenuVO] menu_id: " + menu_id 
						+ "menu_title: " + menu_title 
						+ "menu_parent: " + menu_parent 
						+ "menu_seq: " + menu_seq 
						+ "menu_visible: " + menu_visible 
						+ " ]";
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_title() {
		return menu_title;
	}

	public void setMenu_title(String menu_title) {
		this.menu_title = menu_title;
	}

	public String getMenu_parent() {
		return menu_parent;
	}

	public void setMenu_parent(String menu_parent) {
		this.menu_parent = menu_parent;
	}

	public int getMenu_seq() {
		return menu_seq;
	}

	public void setMenu_seq(int menu_seq) {
		this.menu_seq = menu_seq;
	}

	public String getMenu_visible() {
		return menu_visible;
	}

	public void setMenu_visible(String menu_visible) {
		this.menu_visible = menu_visible;
	}
	
	
}
