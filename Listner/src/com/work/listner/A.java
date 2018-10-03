package com.work.listner;

import java.util.ArrayList;

public class A {
	
	private ArrayList<AListener> listeners = new ArrayList<>();
	
	public void addListener(AListener listener) {
		listeners.add(listener);
	}
	
	public void doSomething() {
		System.out.println("do something");
		for(int i = 0; i < listeners.size(); i++) {
			listeners.get(i).doEvent();
		}
	}

}
