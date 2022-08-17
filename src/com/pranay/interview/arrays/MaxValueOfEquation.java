package com.pranay.interview.arrays;

import java.util.*;

public class MaxValueOfEquation {
    public static void main(String[] args) {
//        int[][] points = {{1,3},{2,0},{5,10},{6,-10}};
//        [[-15,-1],[-14,-5],[-11,1],[-9,7],[-8,18],[-7,-5],[-3,3],[4,14],[12,-4],[13,15],[14,-19],[19,-1]]
//        8
        int[][] points = {{-15, -1}, {-14, -5}, {-11, 1}, {-9, 7}, {-8, 18}, {-7, -5}, {-3, 3}, {4, 14}, {12, -4}, {13, 15}, {14, -19}, {19, -1}};
        int k = 8;
        int ans = findMaxValueOfEquation(points, k);
        System.out.println("Ans : " + ans);
    }

    private static int findMaxValueOfEquation(int[][] points, int k) {
        Deque<Map.Entry<Integer, Integer>> ms = new ArrayDeque<>();
        int res = Integer.MIN_VALUE;

        for (int[] point : points) {
            while (!ms.isEmpty() && point[0] - ms.peekFirst().getValue() > k) {
                ms.pollFirst();
            }

            if (!ms.isEmpty()) {
                res = Math.max(res, ms.peekFirst().getKey() + point[0] + point[1]);
                System.out.println(ms.peek() + "---" + Arrays.toString(point) + "---" + res);
            }

            while (!ms.isEmpty() && point[1] - point[0] > ms.peekLast().getKey()) {
                ms.pollLast();
            }

            ms.offerLast(new AbstractMap.SimpleEntry<>(point[1] - point[0], point[0]));
        }

        return res;
    }
}
