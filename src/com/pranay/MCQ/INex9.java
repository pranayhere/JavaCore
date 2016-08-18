package com.pranay.MCQ;

public class INex9 {
	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = s1;
		s1 += "D";
		System.out.println(s1+" "+s2+" "+(s1==s2));
		
		StringBuffer sb1 = new StringBuffer("ABC");
		StringBuffer sb2 = sb1;
		sb1.append("D");
		System.out.println(sb1+" "+sb2+" "+(sb1==sb2));
		
	}
}
