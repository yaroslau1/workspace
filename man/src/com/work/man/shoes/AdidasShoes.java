package com.work.man.shoes;

public class AdidasShoes implements IShoes{
	
	public AdidasShoes() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void putOn() {
		System.out.println("Adidas shoes put on");
		
	}

	@Override
	public void takeOff() {
		System.out.println("Adidas shoes take off");
		
	}

}
