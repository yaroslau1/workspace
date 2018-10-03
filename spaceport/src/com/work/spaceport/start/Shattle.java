package com.work.spaceport.start;

public class Shattle implements IStart{
	
	public Shattle() {
	}

	@Override
	public boolean check() {
		boolean check = false;
		if((0 + (int) (Math.random() * 10)) > 3){
			check = true;
		}
		return check;
	}

	@Override
	public void startEngine() {
		System.out.println("All engine is STARTED. All systems is OK!");
	}

	@Override
	public void startSpaceShip() {
		System.out.println("Shattle is START!");
	}

}
