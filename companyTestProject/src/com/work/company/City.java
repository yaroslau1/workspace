package com.work.company;

public class City {
	private int id;
	private int population;
	private String name;
	
	public City() {
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setPopularion(int population) {
		this.population = population;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId () {
		return this.id;
	}
	
	 public int getPopulation () {
		return this.population;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void showCity() {
		System.out.println(id + " " + name + " " + population);
	}
	
	@Override
	public String toString() {
		return id + " " + name + " " + population;
	}

}
