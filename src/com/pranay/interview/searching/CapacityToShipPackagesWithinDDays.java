package com.pranay.interview.searching;

/**
 * 1011. Capacity To Ship Packages Within D Days
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class CapacityToShipPackagesWithinDDays {

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;

        CapacityToShipPackagesWithinDDays csp = new CapacityToShipPackagesWithinDDays();
        int cap = csp.shipWithinDays(weights, D);
        System.out.println("Ans : " + cap);
    }

    public int shipWithinDays(int[] weights, int D) {
        int max = 0;
        for (int w: weights)
            max = Math.max(max, w);

        int lo = max;
        int hi = Integer.MAX_VALUE;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            int d = days(weights, mid);

            if (d <= D)
                hi = mid - 1;
            else
                lo = mid + 1;
        }

        return lo;
    }

    public int days(int[] w, int cap) {
        int days = 1;
        int currSum = 0;

        for (int i = 0; i < w.length; i++) {
            if (currSum + w[i] > cap) {
                currSum = 0;
                days++;
            }

            currSum += w[i];
        }

        // System.out.println(days + " --- " + cap);
        return days;
    }
}