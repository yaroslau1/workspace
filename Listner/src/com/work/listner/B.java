package com.work.listner;

public class B implements AListener{

	@Override
	public void doEvent() {
		System.out.println("something doing at A");
	}

}
