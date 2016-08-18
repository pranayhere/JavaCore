package com.pranay.Algorithms;
/*
 * The Best Solution is to do bitwise XOR of all the elements. XOR of all elements gives us odd occurring element. 
 * Please note that XOR of two elements is 0 if both elements are same and XOR of a number x with 0 is x.
 */
public class XORDemo {
	public static void main(String[] args) {
		System.out.println(5^5);
		System.out.println(5^2^5);
		
		
		int x1 = 1^2^3^4^6^7^8^9^10;
		int x2 = 1^2^3^4^5^6^7^8^9^10;
		int missingNo  = x1^x2;
		System.out.println(x1+" "+x2+" "+missingNo);
	}
}
