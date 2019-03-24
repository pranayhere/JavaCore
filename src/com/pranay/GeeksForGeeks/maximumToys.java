package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class maximumToys {
	public static void main(String[] args) {
		int k = 7;
		int[] arr = {1, 2, 4, 3};
		int count = maximumToys(arr, k);
		System.out.println(count);
	}

	private static int maximumToys(int[] arr, int k) {
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
		Collections.sort(list);

		int count = 0;
		int cost = 0;
		for (Integer i : list) {
			cost += i;
			if (cost > k) {
				break;
			}

			count++;
		}
		return count;
	}
}
