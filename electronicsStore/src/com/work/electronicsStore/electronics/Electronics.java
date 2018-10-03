package com.work.electronicsStore.electronics;

public class Electronics {
	private String type;
	private double price;
	private double weight;
	private int year;
	
	public Electronics() {
		
	}
	
	public String getType() {
		return type;
	}
	
	public Electronics(String type, double price, double weight, int year) {
		this.type = type;
		this.price = price;
		this.weight = weight;
		this.year = year;
		
	}
	
	public String toString() {
		return " type = " + type + ", price = " + price + ", weight = " + weight + ", year = " + year + " ";
		
	}

}
