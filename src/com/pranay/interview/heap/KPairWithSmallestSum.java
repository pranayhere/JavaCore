package com.pranay.interview.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairWithSmallestSum {
    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        List<List<Integer>> ans = kSmallestPairs(nums1, nums2, k);
        System.out.println("Ans : " + ans);
    }

    private static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer[]> q = new PriorityQueue<Integer[]>((a, b) -> Integer.compare(a[0] + a[1], b[0] + b[1]));

        int i1 = 0;
        int i2 = 0;
        List<List<Integer>> res = new ArrayList();

        while (i1 < nums1.length && i2 < nums2.length && res.size() < k) {
            if (nums1[i1] < nums2[i2]) {
                for (int i = i2; i < nums2.length; i++) {
                    Integer[] pair = new Integer[]{nums1[i1], nums2[i]};
                    q.add(pair);
                }
                i1++;
            } else {
                for (int i = i1; i < nums1.length; i++) {
                    Integer[] pair = new Integer[]{nums1[i], nums2[i2]};
                    q.add(pair);
                }
                i2++;
            }
            res.add(Arrays.asList(q.poll()));
        }
        while (res.size() < k && !q.isEmpty())
            res.add(Arrays.asList(q.poll()));

        return res;
    }
}
