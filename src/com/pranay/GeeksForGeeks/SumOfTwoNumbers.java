package com.pranay.GeeksForGeeks;

public class SumOfTwoNumbers {
	
	
	public static void main(String[] args) {
		int[] arr = {1, 4, 45, 6, 10, 8};
		int n = 16;
		System.out.println("coming here");
		sumPairs(arr, n);
	}

	private static void sumPairs(int[] arr, int n) {
		int boolMap[] = new int[100000];
		for(int i=0; i<arr.length; i++) {
			int temp = 0;
			temp = n - arr[i];
			if(temp >= 0 && boolMap[temp] == 1) {
				System.out.println("pair matching are : "+arr[i]+" and "+temp);
			}
			boolMap[arr[i]] = 1;
		}
	}
}
