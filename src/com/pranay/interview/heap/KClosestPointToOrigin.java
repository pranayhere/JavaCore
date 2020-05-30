package com.pranay.interview.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// formula distance = Sqrt((x1^2 - x2^2) + (y1^2 - y2^2))

class Distance {
    double dist;
    int[] point;

    public Distance(double dist, int[] point) {
        this.dist = dist;
        this.point = point;
    }
}

public class KClosestPointToOrigin {
    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int K = 2;

        int[][] ans = kClosestSpaceOptimized(points, K);
        for (int[] arr: ans) {
            System.out.println(Arrays.toString(arr));
        }
    }

    private static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Distance> minHeap = new PriorityQueue<>((a, b) -> Double.compare(a.dist, b.dist));
        int[][] res = new int[k][points[0].length];
        for (int point[]: points) {
            double dist = Math.sqrt((point[0] * point[0]) + (point[1] * point[1]));
            minHeap.add(new Distance(dist, point));
        }

        int i = 0;
        while (!minHeap.isEmpty() && i < k) {
            res[i] = minHeap.poll().point;
            i++;
        }
        return res;
    }

    private static int[][] kClosestSpaceOptimized(int[][] points, int k) {
        PriorityQueue<Distance> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.dist, a.dist));
        int[][] res = new int[k][points[0].length];
        for (int point[]: points) {
            double dist = Math.sqrt((point[0] * point[0]) + (point[1] * point[1]));
            maxHeap.add(new Distance(dist, point));
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int i = 0;
        while (!maxHeap.isEmpty()) {
            res[i] = maxHeap.poll().point;
            i++;
        }
        return res;
    }
}
