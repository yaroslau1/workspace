package com.work.man.jacket;

public class AdidasJacket implements IJacket{
	
	public AdidasJacket() {
		
	}

	@Override
	public void putOn() {
		System.out.println("Adidas jacket is put on");
		
	}

	@Override
	public void takeOff() {
		System.out.println("Adidas jacket is take off");
		
	}

}
