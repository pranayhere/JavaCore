package com.pranay.interview.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 632. Smallest Range Covering Elements from K Lists
 * https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
 */
public class SmallestRangeCoveringElementsFromKList {
    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4,10,15,24,26));
        nums.add(Arrays.asList(0,9,12,20));
        nums.add(Arrays.asList(5,18,22,30));

        int[] ans = smallestRange(nums);
        System.out.println("Ans : " + Arrays.toString(ans));
    }

    static class Element {
        int val;
        int idx;
        int row;

        public Element(int r, int i, int v) {
            val = v;
            idx = i;
            row = r;
        }
    }

    private static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            Element e = new Element(i, 0, nums.get(i).get(0));
            pq.offer(e);
            max = Math.max(max, nums.get(i).get(0));
        }

        int range = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;

        while (pq.size() == nums.size()) {
            Element smallest = pq.poll();

            if (max - smallest.val < range) {
                range = max - smallest.val;
                end = max;
                start = smallest.val;
            }

            if (smallest.idx + 1 < nums.get(smallest.row).size()) {
                smallest.idx = smallest.idx + 1;
                smallest.val = nums.get(smallest.row).get(smallest.idx);

                pq.offer(smallest);

                if (smallest.val > max)
                    max = smallest.val;
            }
        }

        return new int[]{start, end};
    }
}
