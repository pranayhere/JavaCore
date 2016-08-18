package com.pranay.comparable;

public class Emp implements Comparable<Emp>{
	private String name;
	private int id;

	public Emp(String name, int id) {
		this.name = name;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString(){
		return "Name: "+this.name+"-- id: "+this.id;
	}
	@Override
	public int compareTo(Emp emp) {
		// TODO Auto-generated method stub
		int result = Integer.compare(this.id, emp.id);
		if(result == 0)
			return this.name.compareTo(emp.name);
		return result;
	}
}
