package com.work.man.jacket;

public class PumaJacket implements IJacket{
	
	public PumaJacket() {
		
	}

	@Override
	public void putOn() {
		System.out.println("Puma jacket is put on");
		
	}

	@Override
	public void takeOff() {
		System.out.println("Puma jacket is take off");
		
	}

}
