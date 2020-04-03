package com.pranay.interview.heap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class ArrayEntry {
	public Integer val;
	public Integer arrayId;

	public ArrayEntry(Integer val, Integer arrayId) {
		this.val = val;
		this.arrayId = arrayId;
	}
}

public class MergeSortedArrays {
	public static void main(String[] args) {
		List<List<Integer>> sorted = new ArrayList<>();
		sorted.add(Arrays.asList(3, 5, 7));
		sorted.add(Arrays.asList(0, 6));
		sorted.add(Arrays.asList(0, 6, 28));

		List<Integer> merged = mergeList(sorted);
		System.out.println("merged list is : " + merged);
	}

	private static List<Integer> mergeList(List<List<Integer>> sortedArrays) {
		List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());
		for (List<Integer> array : sortedArrays) {
			iters.add(array.iterator());
		}

		PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
		for (int i = 0; i < iters.size(); ++i) {
			if (iters.get(i).hasNext()) {
				minHeap.add(new ArrayEntry(iters.get(i).next(), i));
			}
		}


		List<Integer> result = new ArrayList<>();
		while (!minHeap.isEmpty()) {
			ArrayEntry headEntry = minHeap.poll();
			result.add(headEntry.val);
			if (iters.get(headEntry.arrayId).hasNext()) {
				minHeap.add(new ArrayEntry(iters.get(headEntry.arrayId).next(), headEntry.arrayId));
			}
		}

		return result;
	}
}
