package com.pranay.MCQ;

public class INex15 {
	public static String str = "Good days!";
	
	public static void main(String[] args) {
		char[] chr  = str.substring(5, str.length()).toCharArray();
		chr[0] = 'n';
		chr[1] = 'i';
		chr[2] = 'g';
		chr[3] = 'h';
		chr[4] = 't';
		
		System.out.println(str);
	}
}
