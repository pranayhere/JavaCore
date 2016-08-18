package com.pranay.MCQ;

public class INex2 {
	public String fun() {
		try {
			throw new Exception();
		}catch (Exception e) {
			System.out.println("in catch block");
			//System.exit(0);
			return "catch";
		}finally {
			System.out.println("in finally block");
			return "finally";			
		}
		//return "fun";
	}
	public static void main(String[] args) {
		INex2 t = new INex2();
		t.fun();
	}
}
