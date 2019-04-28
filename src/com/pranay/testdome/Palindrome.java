package com.pranay.testdome;

public class Palindrome {
    public static boolean isPalindrome(String word) {
    	word = word.toLowerCase();
    	StringBuffer sb = new StringBuffer(word);
    	String reverse = sb.reverse().toString();
    	if (word.equals(reverse))
    		return true;
    	return false;
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Deleveled"));
    }
}