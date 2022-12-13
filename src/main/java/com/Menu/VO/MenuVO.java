package com.Menu.VO;

public class MenuVO {
	private int mid, type, price, price_100g;
	private String name, addr, pictureurl;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice_100g() {
		return price_100g;
	}
	public void setPrice_100g(int price_100g) {
		this.price_100g = price_100g;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPictureurl() {
		return pictureurl;
	}
	public void setPictureurl(String pictureurl) {
		this.pictureurl = pictureurl;
	}
	@Override
	public String toString() {
		return "MenuVO [mid=" + mid + ", type=" + type + ", price=" + price + ", price_100g=" + price_100g + ", name="
				+ name + ", addr=" + addr + ", pictureurl=" + pictureurl + "]";
	}
	
}
