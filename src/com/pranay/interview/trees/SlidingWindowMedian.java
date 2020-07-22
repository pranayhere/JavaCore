package com.pranay.interview.trees;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SlidingWindowMedian {
    public static void main(String[] args) {
//        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7, 5, 6, 7, 3, 2, 5, 3, 5, 6, 7, 8, 5, 2, 2, 4, 4, 5, 6, 7, 8, 2, 2, 2, 2, 4, 5, 6, 7, 43, 2, 2, 1};
//        int k = 7;

        int[] nums = {1,2,3,4,2,3,1,4,2};
        int k = 3;

        SlidingWindowMedian swm = new SlidingWindowMedian();
        double[] median = swm.medianSlidingWindow(nums, k);
        System.out.println(Arrays.toString(median));
    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

    private double[] medianSlidingWindow(int[] nums, int k) {
        double[] median = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);

            if (i >= k - 1) {
                median[i - k + 1] = getMedian();
                remove(nums[i - k + 1]);
            }
//            System.out.println("maxHeap : " + maxHeap);
//            System.out.println("minHeap : " + minHeap);
//            System.out.println(Arrays.toString(median));
//            System.out.println("--------");
        }
        return median;
    }

    private void add(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());

        if (minHeap.size() > maxHeap.size())
            maxHeap.add(minHeap.poll());
    }

    private void remove(int x) {
        if (maxHeap.peek() >= x)
            maxHeap.remove(x);
        else
            minHeap.remove(x);

        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        } else if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
    }

    private double getMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return ((double) (minHeap.peek() + maxHeap.peek())) / 2;
        }
        return (double) maxHeap.peek();
    }
}