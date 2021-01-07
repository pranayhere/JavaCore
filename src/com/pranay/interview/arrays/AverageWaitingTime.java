package com.pranay.interview.arrays;

/**
 * 1701. Average Waiting Time
 * https://leetcode.com/problems/average-waiting-time/
 */
public class AverageWaitingTime {
    public static void main(String[] args) {
        int[][] customers = {{5, 2}, {5, 4}, {10, 3}, {20, 1}};
        double awt = averageWaitingTime(customers);
        System.out.println("Ans : " + awt);
    }

    private static double averageWaitingTime(int[][] customers) {
        double wt = 0.0;
        int curTime = 0;

        for (int[] cust: customers) {
            int at = cust[0];
            int time = cust[1];

            if (curTime < at)
                curTime = at;

            curTime += time;

            wt += curTime - at;
        }

        return wt / customers.length;
    }
}
