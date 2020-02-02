package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KWeakestRowInMatrix {
	public static void main(String[] args) {
		int[][] mat = {{1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
				{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
				{1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0},
				{1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};

		int k = 1;
		int[] ans = kWeakestRows(mat, k);
		System.out.println(ans);
	}

	private static int[] kWeakestRows(int[][] mat, int k) {
		Map<Integer, Integer> hm = new HashMap<>();
		Map<Integer, ArrayList<Integer>> bucketSort = new TreeMap<>();
		List<Integer> ans = new ArrayList<>();
		int[] finalAns = new int[k];
		for (int i=0; i<mat.length; i++) {
			int count = 0;
			for (int j=0; j<mat[i].length; j++) {
				count += mat[i][j];
			}
			hm.put(i, count);
		}

		hm.forEach((key, val) -> System.out.println(key + " - " + val));

		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			int key = entry.getKey();
			int val = entry.getValue();

			ArrayList<Integer> li = bucketSort.getOrDefault(val, new ArrayList<>());
			li.add(key);
			bucketSort.put(val, li);
		}

		bucketSort.forEach((key, val) -> System.out.println(key + " - " + val));

		bucketSort.forEach((key ,val) -> {
			ans.addAll(val);
		});

		System.out.println(ans);

		for (int i = 0; i<k; i++) {
			finalAns[i] = ans.get(i);
		}

		return finalAns;
	}
}
