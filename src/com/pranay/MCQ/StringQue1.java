package com.pranay.MCQ;

public class StringQue1 {
	public static void main(String[] args) {
		String s3 = "A";
		String s4 = s3.intern();
		
		if(s3.equals(s4) && s3==s4) {
			System.out.println("here1");
		}
		if(!s3.equals(s4) && s3==s4) {
			System.out.println("here2");
		}
		if(s3.equals(s4) && s3!=s4) {
			System.out.println("here3");
		}
		if(!s3.equals(s4) && s3!=s4) {
			System.out.println("here4");
		}	
	}	
}
