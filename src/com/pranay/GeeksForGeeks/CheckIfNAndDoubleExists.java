package com.pranay.GeeksForGeeks;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndDoubleExists {
	public static void main(String[] args) {
		int[] arr = {3,1,7,11};
		boolean exists = checkIfExist(arr);
		System.out.println(exists);
	}

	private static boolean checkIfExist(int[] arr) {
		Set<Integer> hs = new HashSet<>();
		for (int i=0; i<arr.length; i++) {
			if (arr[i] % 2 == 0 && hs.contains(arr[i]/2) || hs.contains(arr[i] *2)) {
				return true;
			}
			hs.add(arr[i]);
		}
		return false;
	}
}
