package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintPermutations {
	public static void main(String[] args) {
//		int[] arr = {1, 2, 3};
//		List<List<Integer>> permutations = printPermutations(arr);
//		for (List<Integer> list: permutations) {
//			System.out.println(list.toString());
//		}

			int z = 5;
			int lo = 0;
			int hi = z;
			List<List<Integer>> ans = new ArrayList<>();
			while (lo <= hi) {
				int val = lo + hi;
				if (val == z) {
					ans.add(new ArrayList<>());
				}
			}

	}

	private static List<List<Integer>> printPermutations(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		helper(new ArrayList<Integer>(), ans, nums, new int[nums.length]);
		return null;
	}

	private static List<List<Integer>> helper(ArrayList<Integer> curr, List<List<Integer>> ans, int[] nums, int[] marked) {
		return null;
	}
}
