package com.pranay.GeeksForGeeks.amazon;

public class kadenSubarrayWithMaximumSum {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, -2, 5};
		int sum = SubarrayWithMaximumSum(arr);
		System.out.println(sum);
	}

	private static int SubarrayWithMaximumSum(int[] arr) {
		int currentMax = 0;
		int finalMax = 0;
		for (int i: arr) {
			currentMax += i;
			if (currentMax < 0)
				currentMax = 0;
			if (finalMax < currentMax)
				finalMax = currentMax;
		}
		System.out.println("final : " + finalMax);
		return finalMax;
	}
	
//	int maxSubArraySum(int a[], int size) 
//	{ 
//	   int max_so_far = a[0]; 
//	   int curr_max = a[0]; 
//	  
//	   for (int i = 1; i < size; i++) 
//	   { 
//	        curr_max = max(a[i], curr_max+a[i]); 
//	        max_so_far = max(max_so_far, curr_max); 
//	   } 
//	   return max_so_far; 
//	} 
}
