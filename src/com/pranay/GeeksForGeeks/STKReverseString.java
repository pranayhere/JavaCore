package com.pranay.GeeksForGeeks;

public class STKReverseString {
	public static Stack stk = new Stack(100);
	
	public String reverse(char arr[]) {
		for(int i=0; i<arr.length; i++) {
			stk.push(arr[i]);
		}
		String str1 = "";
		for(int i=0; i<arr.length; i++) {
			str1 = str1.concat(""+stk.pop());
		}
		return str1;
	}
	
	public static void main(String[] args) {
		STKReverseString strRev = new STKReverseString();
		String str = "pranay sankpal";
		char[] arr = new char[str.length()];
		for(int i=0; i<str.length(); i++)
			arr[i] = str.charAt(i);
		String rev = strRev.reverse(arr);
		System.out.println(rev);
	}
}
