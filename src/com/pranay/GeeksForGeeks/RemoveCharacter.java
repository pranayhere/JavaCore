package com.pranay.GeeksForGeeks;

public class RemoveCharacter {
	public static void main(String[] args) {
		String str = "pranay";
		char ch = 'a';
		StringBuilder sb = new StringBuilder();
		char[] letters = str.toCharArray();
		
		for(char c : letters) {
			if(c != ch) {
				sb.append(c);
			}
		}
		
		System.out.println(sb.toString());
	}
}
