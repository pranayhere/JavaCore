package com.pranay.GeeksForGeeks;

public class EquilibriumPosition {

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 2, 2};
		int point = getEquilibriumPoint(arr);
		System.out.println("EquilibriumPoint is : " + point);
	}

	private static int getEquilibriumPoint(int[] arr) {
		int totalSum = 0;
		for (int i : arr) {
			totalSum += i;
		}
		System.out.println(totalSum);
		int leftSum = 0;
		int rightSum = 0;
		for (int i=0; i<arr.length - 1; i++) {
			int leftIdx = i-1;
			if (leftIdx < 0) 
				continue;
			leftSum += arr[leftIdx];
			rightSum = totalSum - arr[i] - leftSum;
//			System.out.println("i : " + i);
//			System.out.println("Left Sum : " + leftSum);
//			System.out.println("Right Sum : " + rightSum);
			if (leftSum == rightSum) {
				return i;
			}
		}
		return 0;
	}

}
