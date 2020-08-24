package com.pranay.interview.searching;

import java.util.Arrays;

/**
 * 1552. Magnetic Force Between Two Balls
 * https://leetcode.com/problems/magnetic-force-between-two-balls/
 */
public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int[] position = {1, 2, 3, 4, 7};
        int m = 3;

        int minForce = maxDistance(position, m);
        System.out.println("Min force : " + minForce);
    }

    private static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        
        int lo = 0;
        int hi = position[position.length - 1];

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (canPut(position, m, mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo - 1;
    }

    /**
     * Returns whether we can put m balls so that maximum distance between any two balls not exceed max
     */
    private static boolean canPut(int[] positions, int m, int maxForce) {
        int count = 1;
        int prev = positions[0];

        for (int i = 0; i < positions.length; i++) {
            if (positions[i] - prev >= maxForce) {
                prev = positions[i];
                count++;
            }
        }
        return count >= m;
    }

}
