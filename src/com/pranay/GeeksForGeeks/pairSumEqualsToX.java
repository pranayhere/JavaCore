package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class pairSumEqualsToX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 4, 45, 6, 10, -8}; 
        int sum = 16; 
        
        findPairSum(arr, sum);
	}

	public static void findPairSum(int[] arr, int sum) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i=0; i<arr.length; i++) {
			int temp = sum - arr[i];
			if (hm.containsKey(arr[i])) {
				System.out.println(hm.get(arr[i]) + " " +(i+1));
			}
			hm.put(temp, i+1);
		}
	}
}
