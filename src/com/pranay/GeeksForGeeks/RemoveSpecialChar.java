package com.pranay.GeeksForGeeks;

public class RemoveSpecialChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "this is str. this is str 2";
		String result = str.replaceAll("[-+.^:,]","");
		System.out.println(result);
	}

}
