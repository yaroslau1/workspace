package com.work.listner;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		B c = new B();
		
		a.addListener(b);
		a.addListener(c);
		
		a.doSomething();
		
		int one[] = new int[10];
		int two[] = new int[10];
		
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i = 0; i < 45; i++) {
			list.add(i);
		}
		
		int j = 0;
		int k = 0;
		for(int i = 0; i < list.size(); i++) {
			if(i >= 20) {
				//k++;
				j = 20*k;
			}
			if(i-j < 10) {
				one[i-j] = list.get(i);
			}
			if(i-j >= 10 && i-j < 20) {
				two[i-10-j] = list.get(i);
			}
			
			
		}
		
		System.out.println(Arrays.toString(one));
		System.out.println(Arrays.toString(two));

	}

}
