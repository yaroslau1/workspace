package com.work.collections;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainCollections {

	public static void main(String[] args) {
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		
		long start = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++) {
			arrayList.add((int) (0 + Math.random() * 10));
		}
		System.out.println(arrayList);
		for(int i = 999; i >= 0; i--) {
			arrayList.remove(i);
		}
		long finish = System.currentTimeMillis();
		System.out.println(finish - start);
		
		List<Integer> linkedList = new LinkedList<>();
		start = System.currentTimeMillis();
		for(int i = 0; i < 1000; i++) {
			linkedList.add((int) (0 + Math.random() * 10));
		}
		System.out.println(linkedList);
		for(int i = 999; i >= 0; i--) {
			linkedList.remove(i);
		}
		finish = System.currentTimeMillis();
		System.out.println(finish - start);
		

	}

}
