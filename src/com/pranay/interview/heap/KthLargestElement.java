package com.pranay.interview.heap;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int num = findKthLargest(nums, k);
        System.out.println("Ans : " + num);
    }

    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int n: nums) {
            pq.offer(n);

            if (pq.size() > k)
                pq.poll();
        }

        return pq.size() == k ? pq.peek() : -1;
    }
}
