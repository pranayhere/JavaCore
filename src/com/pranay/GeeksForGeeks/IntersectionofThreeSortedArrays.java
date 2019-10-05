package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionofThreeSortedArrays {
	public static void main(String[] args) {
		int[] arr1 = {1,2,3,4,5};
		int[] arr2 = {1,2,5,7,9};
		int[] arr3 = {1,3,4,5,8};
		List<Integer> ans = arraysIntersection(arr1, arr2, arr3);
		System.out.println(ans.toString());
	}

	public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
		Map<Integer, Integer> hm = new HashMap<>();
		List<Integer> ans = new ArrayList<>();
		for (int i: arr1) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}
		for (int i: arr2) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}
		for (int i: arr3) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			if (entry.getValue() == 3) {
				ans.add(entry.getKey());
			}
		}
		return ans;
	}
}
