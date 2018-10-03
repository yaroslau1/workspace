package com.work.man.shoes;

public class PumaShoes implements IShoes{
	
	public PumaShoes() {
		
	}

	@Override
	public void putOn() {
		System.out.println("Puma shoes put on");
		
	}

	@Override
	public void takeOff() {
		System.out.println("Puma shoes take off");
		
	}

}
