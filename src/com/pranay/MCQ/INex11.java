package com.pranay.MCQ;

public interface Vehicle {
	String name = "Generic";
}

class car implements Vehicle {
	car(String vn) {
		name = vn;
	}
	void pritnName() {
		System.out.println(name);
	}
}
public class INex11 {
	public static void main(String[] args) {
		car c = new car("Maruti");
		c.pritnName();
	}
}
