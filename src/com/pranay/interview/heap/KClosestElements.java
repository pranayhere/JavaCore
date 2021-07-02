package com.pranay.interview.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int x = 3;

        List<Integer> ans = findClosestElements(arr, k, x);
        System.out.println(ans);
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(a - x) == Math.abs(b - x) ? a - b : Math.abs(a - x) - Math.abs(b - x));

        for (int n: arr) {
            pq.offer(n);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                ans.add(pq.poll());
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
