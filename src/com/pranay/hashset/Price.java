package com.pranay.hashset;

import java.util.Objects;

public class Price {
	private String name;
	private int cost;
	
	public Price(){}
	
	public Price(String name, int cost) {
		super();
		this.name = name;
		this.cost = cost;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
/*	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result *= cost * prime;
		result += name.hashCode();
		return result;
	}
*/	
	public boolean equals(Object obj){
		if(obj == this)
			return true;
		if(obj == null || obj.getClass() != this.getClass())
			return false;
		Price p = (Price) obj;
		return this.cost == p.cost 
				&& (name == p.name 
	                || (name != null && name.equals(p.getName())));
	}

	@Override
	public String toString() {
		return "Price [name=" + name + ", cost=" + cost + "]";
	}
	
	
}
