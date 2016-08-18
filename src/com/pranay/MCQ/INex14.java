package com.pranay.MCQ;

class TestWrapper {
	Boolean flag;
	void test() {
		if(flag==true)
			System.out.println("flag is set");
		else
			System.out.println("flag is not set");
	}
}

public class INex14 {
	public static void main(String[] args) {
		TestWrapper tw = new TestWrapper();
		tw.test();
	}
}
