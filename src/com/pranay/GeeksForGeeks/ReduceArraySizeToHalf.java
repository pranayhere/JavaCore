package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReduceArraySizeToHalf {
	public static void main(String[] args) {
		int[] arr = {3,3,3,3,5,5,5,2,2,7};
		int ans = minSetSize(arr);
		System.out.println(ans);
	}

	private static int minSetSize(int[] arr) {
		Map<Integer, Integer> hm = new HashMap<>();
		int halfCount = arr.length / 2;
		for (int i =0; i<arr.length; i++) {
			hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
		}

		hm.forEach((k, v) -> System.out.println(k + " - " + v));
		List Listofvalues= new ArrayList(hm.values());
		Collections.sort(Listofvalues);
		Collections.reverse(Listofvalues);

		int count = 0;
		int pointer = 0;
		for (Object i: Listofvalues) {
			if (count < halfCount) {
				int val = (Integer) i;
				count += val;
				pointer++;
			}
		}
		return pointer;
	}
}
