package com.kedu.beans;

public class SamsungTv implements Tv {
	
	private Speaker speaker ;
	
	private String brand;
	private int price;
	
	
	public SamsungTv() {}
	public SamsungTv(Speaker speaker, String brand, int price) {
		this.speaker = speaker;
		this.brand = brand;
		this.price = price;
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
	
	public void powerOn() {}
	public void powerOff() {}
	public void volumeUp() {
		this.speaker.volumUp();
	}
	public void volumeDown() {}
	
}
