package com.work.man;

import com.work.man.jacket.IJacket;
import com.work.man.pants.IPants;
import com.work.man.shoes.IShoes;

public class Man implements IMan{
	private String name;
	private IJacket jacket;
	private IPants pants;
	private IShoes shoes;
	
	public Man() {
		
	}
	
	public Man(String name, IJacket jacket, IPants pants, IShoes shoes) {
		this.name = name;
		this.jacket = jacket;
		this.pants = pants;
		this.shoes = shoes;
	}

	@Override
	public void dressed() {
		jacket.putOn();
		pants.putOn();
		shoes.putOn();
		
	}

	@Override
	public void undressed() {
		jacket.takeOff();
		pants.takeOff();
		shoes.takeOff();
		
	}

}
