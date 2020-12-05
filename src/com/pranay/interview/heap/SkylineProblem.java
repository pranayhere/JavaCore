package com.pranay.interview.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 218. The Skyline Problem
 * https://leetcode.com/problems/the-skyline-problem/
 */

public class SkylineProblem {
    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<List<Integer>> skyline = getSkyline(buildings);
        System.out.println("Skyline : " + skyline);
    }

    private static List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> heights = new ArrayList<>();

        for (int[] b : buildings) {
            heights.add(List.of(b[0], -b[2]));
            heights.add(List.of(b[1], b[2]));
        }

        heights.sort((a, b) -> !a.get(0).equals(b.get(0)) ? a.get(0) - b.get(0) : a.get(1) - b.get(1));

        System.out.println(heights);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int prev = 0;

        for (List<Integer> h : heights) {
            if (h.get(1) < 0) {
                pq.add(-h.get(1));
            } else {
                pq.remove(h.get(1));
            }

            int curr = pq.peek();
            System.out.println("height : " + h + " Curr : " + curr + " Prev : " + prev);
            System.out.println(pq);
            if (curr != prev) {
                res.add(List.of(h.get(0), curr));
                prev = curr;
            }
        }

        return res;
    }

    public List<List<Integer>> getSkyline2(int[][] buildings) {
        List<int[]> A = new ArrayList<>();
        for (int[] b: buildings) {
            A.add(new int[]{b[0], b[2]});
            A.add(new int[]{b[1], -b[2]});
        }

        Collections.sort(A, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int[] a: A)
            System.out.println(Arrays.toString(a));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int prev = 0;

        List<List<Integer>> ans = new ArrayList<>();

        for (int[] a: A) {
            if (a[1] > 0)
                pq.offer(a[1]);
            else
                pq.remove(-a[1]);

            int curr = pq.peek();
            if (curr != prev) {
                ans.add(List.of(a[0], curr));
                prev = curr;
            }
        }

        return ans;
    }
}
