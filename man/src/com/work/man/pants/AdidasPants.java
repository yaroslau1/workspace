package com.work.man.pants;

public class AdidasPants implements IPants{
	
	public AdidasPants() {
		
	}

	@Override
	public void putOn() {
		System.out.println("Adidas pants is put on");

	}

	@Override
	public void takeOff() {
		System.out.println("Adidas pants is take off");

	}

}
