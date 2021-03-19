package com.pranay.interview.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1792. Maximum Average Pass Ratio
 * https://leetcode.com/problems/maximum-average-pass-ratio/
 * https://leetcode.com/problems/maximum-average-pass-ratio/discuss/1108263/PythonJava-Max-Heap-Clean-and-Concise
 */
public class MaximumAveragePassRatio {
    public static void main(String[] args) {
        int[][] classes = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents = 2;

        MaximumAveragePassRatio mapr = new MaximumAveragePassRatio();
        double ans = mapr.maxAverageRatio(classes, extraStudents);
        System.out.println("Ans : " + ans);
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(Comparator.comparingDouble(o -> -o[0]));
        for (int[] c : classes) {
            double a = c[0], b = c[1];
            maxHeap.offer(new double[]{profit(a, b), a, b});
        }

        while (extraStudents-- > 0) {
            double[] top = maxHeap.poll();
            double a = top[1], b = top[2];
            maxHeap.offer(new double[]{profit(a+1, b+1), a+1, b+1});
        }

        double ans = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            double a = top[1], b = top[2];
            ans += a / b;
        }

        return ans / classes.length;
    }

    public double profit(double a, double b) {
        return (a + 1) / (b + 1) - a / b;
    }
}
