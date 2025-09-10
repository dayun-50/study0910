package com.kedu.beans;

public class LGTv implements Tv {
	
	public LGTv() {
		System.out.println("LG Tv 생성 ㅎㅇㅎㅇ");
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	private String brand;
	private int price;
	
	public void powerOn() {}
	public void powerOff() {}
	public void volumeUp() {}
	public void volumeDown() {}
	
}
