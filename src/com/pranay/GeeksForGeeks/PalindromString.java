package com.pranay.GeeksForGeeks;

public class PalindromString {
	public static void main(String[] args) {
		String str = "abdcba";
		int i = 0; 
		int j = str.length()-1;
		while(i<=j) {
			if(str.charAt(i) == str.charAt(j)) {
				i++;
				j--;
			}
			else {
				System.out.println("Not Palindrom");
				break;
			}
		}
		if(i>=j) 
			System.out.println("String is Palindrom");
	}
}
