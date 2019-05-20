package com.pranay.GeeksForGeeks;

public class nykaatest1 {

	public static void main(String[] args) {
		int n = 4;
		printMetrix(n);
	}

//	private static void printMetrix(int n) {
//		int spaces  = n-1;
//		int num;
//		for (int i = 1; i <= n; i++) {
//			num = 1;
//			for(int j = 1; j<=n*2-1; j++) {
//				if (j < spaces) {
//					System.out.print(" ");
//				} else {
//					if (num <= i) {
//						System.out.print(num++);
//					} else {
//						System.out.print(num--);
//					}
//				}
//			}
//			spaces--;
//			System.out.print("\n");
//		}
//	}
	
	private static void printMetrix(int n) {
		int spaces = n;
		boolean negative;
		int num;
		
		for (int i=1; i<=n; i++) {
			spaces--;
			num = 1;
			for (int j=1; j<=spaces; j++) {
				System.out.print(" ");
			}
			
			for (int j = 1; j<=i*2-1; j++) {
				if (j < i) 
					System.out.print(num++);
				else if (j >= i) 
					System.out.print(num--);
			}
			System.out.println();
		}
	}
}