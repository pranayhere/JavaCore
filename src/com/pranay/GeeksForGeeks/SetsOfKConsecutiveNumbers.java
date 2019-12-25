package com.pranay.GeeksForGeeks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SetsOfKConsecutiveNumbers {
	public static void main(String[] args) {
		int[] nums = {15,16,17,18,19,16,17,18,19,20,6,7,8,9,10,3,4,5,6,20};
		int k = 5;
		boolean ans = isPossibleDivide(nums, k);
		System.out.println(ans);
	}

	private static boolean isPossibleDivide(int[] nums, int k) {
		Arrays.sort(nums);
		Map<Integer, Integer> hm = new LinkedHashMap<Integer, Integer>();
		for (int num: nums)
			hm.put(num, hm.getOrDefault(num, 0) + 1);

		while (!hm.isEmpty() && hm.size() >= k) {
			int count = 0;
			Iterator<Integer> iterator = hm.keySet().iterator();
			Integer prev = null;
			while(iterator.hasNext()) {
				Integer key = iterator.next();

				if (prev != null && key - prev > 1) {
					return false;
				}

				int val = hm.get(key);
				val--;
				if (val > 0) {
					count++;
					hm.put(key, val);
				} else {
					count++;
					iterator.remove();
				}

				prev = key;
				if (count == k) {
					break;
				}
			}
		}
		return hm.isEmpty();
	}

	public boolean isPossibleDivide2(int[] nums, int k) {
		if(nums.length % k != 0) return false;
		TreeMap<Integer,Integer> map = new TreeMap<>();

		for(int x: nums)
			map.put(x,map.getOrDefault(x,0)+1);

		for(int n: map.keySet()){
			int curr = map.get(n);

			if(curr == 0) continue;

			for(int i = n; i < k + n; i++){
				if(!map.containsKey(i) || map.get(i) <= 0)
					return false;
				map.put(i,map.get(i) - curr);

			}
		}

		return true;
	}
}
