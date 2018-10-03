package com.work.spaceport.port;

import com.work.spaceport.start.Shattle;

public class RunSpaceShips {

	public static void main(String[] args) {
		SpacePort limbo = new SpacePort("Limbo");
		limbo.welcome(limbo);
		
		Shattle shattle = new Shattle();
		
		limbo.launching(shattle);
		

	}

}
