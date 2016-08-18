package com.pranay.MCQ;

public class INex17 {
	static public String mystery(String input){
		String s1 = input.substring(0,1);
		String s2 = input.substring(0,input.length()-1);
		String s3 = input.substring(input.length()-1);
		
		if(input.length() <= 3)
			return s3+s2+s1;
		else
			return s1+mystery(s2)+s3;
	}
	public static void main(String[] args) {
		System.out.println(mystery("GOVERNMENT"));
	}
}
