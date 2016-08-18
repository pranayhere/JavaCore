package com.pranay.MCQ;

public class INex19 {
	public static void main(String[] args) {
		try {
			throw 10;
		}
		catch(int e) {
			System.out.println("Got the exception "+e);
		}
	}
}
