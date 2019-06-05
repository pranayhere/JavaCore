package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class KFrequentNumbers {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 2, 2, 5, 1, 4, 2, 1, 4, 2 };
		int k = 2;
//		List<Integer> freq = topKFrequentHeap(nums, k);
//		System.out.println(freq);
		
		List<Integer> freq2 = topKFrequentBucketSort(nums, k);
		System.out.println(freq2);
		
	}

	private static List<Integer> topKFrequentBucketSort(int[] nums, int k) {
		Map<Integer, Integer> hm = new HashMap<>();
		for (int num : nums)
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		
		hm.forEach((key, val) -> {
			System.out.println(key+ " : " +val);
		});

		int max = 0;
		for(Map.Entry<Integer, Integer> entry:hm.entrySet()) {
			max = Math.max(max, entry.getValue());
		}
		
		ArrayList<Integer>[] arr = new ArrayList[max + 1];
		for(int i=1; i<=max; i++){
	        arr[i]=new ArrayList<Integer>();
	    }
		
		for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			arr[entry.getValue()].add(entry.getKey());
		}
		
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i = max; i>=0; i--) {
			if (arr[i].size() > 0) {
				for(int ele : arr[i]) {
					result.add(ele);
				}
			}
			k--;
			if (k < 0) {
				break;
			}
		}
		return result;
	}

	private static List<Integer> topKFrequentHeap(int[] nums, int k) {
		// count the frequency of each element
		Map<Integer, Integer> hm = new HashMap<>();
		for (int num : nums) {
			hm.put(num, hm.getOrDefault(num, 0) + 1);
		}

		hm.forEach((key, val) -> {
			System.out.println(key + " : " + val);
		});

		// Create a min heap
		PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparing(e -> e.getValue()));
		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			queue.offer(entry);
			if (queue.size() > k) {
				queue.poll();
			}
			System.out.println(queue);
		}

		List<Integer> result = new ArrayList<>();
		while (queue.size() > 0) {
			result.add(queue.poll().getKey());
		}

		// reverse the order
		Collections.reverse(result);

		return result;
	}
}
