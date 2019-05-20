package com.pranay.GeeksForGeeks;

public class nykaatest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		distinctCoins(5);
	}

	private static void distinctCoins(int n) {
		for (int i = 1; i<= n; i++) {
			for (int j = 1; j<= n; j++) {
				if (i+j <=5 && i != j) {
					System.out.println(i+ ", "+j);					
				}
			}
		}
	}
}
