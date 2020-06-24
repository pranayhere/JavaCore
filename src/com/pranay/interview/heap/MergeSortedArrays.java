package com.pranay.interview.heap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class ArrayEntry {
    public int val;
    public int arrayId;

    public ArrayEntry(int val, int arrayId) {
        this.val = val;
        this.arrayId = arrayId;
    }
}

public class MergeSortedArrays {
	public static void main(String[] args) {
		List<List<Integer>> sorted = new LinkedList<>();
		sorted.add(Arrays.asList(1, 4, 5));
		sorted.add(Arrays.asList(1, 3, 4));
		sorted.add(Arrays.asList(2, 6));

		List<Integer> merged = mergeList(sorted);
		System.out.println("merged list is : " + merged);
	}

	private static List<Integer> mergeList(List<List<Integer>> sortedArrays) {
	    List<Iterator<Integer>> itrs = new ArrayList<>();
	    List<Integer> res = new ArrayList<>();

	    for (List<Integer> arr: sortedArrays) {
	        itrs.add(arr.iterator());
        }

	    PriorityQueue<ArrayEntry> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
	    for (int i = 0; i<itrs.size(); i++) {
	        if (itrs.get(i).hasNext()) {
	            pq.add(new ArrayEntry(itrs.get(i).next(), i));
            }
        }

	    while (!pq.isEmpty()) {
	        ArrayEntry curr = pq.poll();
	        res.add(curr.val);
	        if (itrs.get(curr.arrayId).hasNext()) {
	            pq.add(new ArrayEntry(itrs.get(curr.arrayId).next(), curr.arrayId));
            }
        }
		return res;
	}
}
