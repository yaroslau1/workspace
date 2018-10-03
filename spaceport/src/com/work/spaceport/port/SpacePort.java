package com.work.spaceport.port;

import com.work.spaceport.start.IStart;

public class SpacePort {
	
	private String name;
	
	public SpacePort() { }
	
	public SpacePort(String name) {
		this.name = name;
	}
	
	public void welcome(SpacePort spacePort) {
		System.out.println("Welcome to the space port " + spacePort.name);
	}
	
	public void launching(IStart istart) {
		if(istart.check()) {
			istart.startEngine();
			System.out.println("10...");
			System.out.println("...9...");
			System.out.println("...8...");
			System.out.println("...7...");
			System.out.println("...6...");
			System.out.println("...5...");
			System.out.println("...4...");
			System.out.println("...3...");
			System.out.println("...2...");
			System.out.println("...1...");
			System.out.println("...0...");
			System.out.println("START");
			istart.startSpaceShip();
		}
		else {
			System.out.println("ERROR check is FAILED");
		}
	}

}
