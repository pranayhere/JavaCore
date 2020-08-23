package com.pranay.interview.arrays;

/**
 * 1562. Find Latest Group of Size M
 * https://leetcode.com/problems/find-latest-group-of-size-m/
 */

import java.util.Arrays;
import java.util.TreeSet;

public class LatestGroupOfSizeM {
    public static void main(String[] args) {
        int[] arr = {3,5,1,2,4};
        int m = 1;

        int ans = findLatestStepOptimized(arr, m);
        System.out.println("Ans : " + ans);
    }

    private static int findLatestStep(int[] arr, int m) {
        int[] A = new int[arr.length];
        int latest = -1;
        for (int i = 0; i < arr.length; i++) {
            A[arr[i] - 1] = 1;

            int sum = 0;
            for (int j = 0; j < A.length;) {
                while (j < A.length && A[j] == 1) {
                    sum++;
                    j++;
                }

                if (sum == m)
                    latest = i + 1;

                j++;
                sum = 0;
            }
        }
        return latest;
    }

    public static int findLatestStepOptimized(int[] arr, int m) {
        if(m == arr.length) return arr.length;

        TreeSet<int[]> set = new TreeSet<>((a, b) -> a[0] - b[0]); // no overlap interval
        set.add(new int[]{1, arr.length});

        for(int i = arr.length - 1; i >= 0; i--) {
            int[] cur = set.floor(new int[]{arr[i]});
            System.out.println(Arrays.toString(cur) + " " + arr[i]);

            if(cur == null || arr[i] > cur[1]) continue;
            set.remove(cur);

            if(arr[i] - cur[0] == m || cur[1] - arr[i] == m) return i;

            if(arr[i] - cur[0] > m) set.add(new int[]{cur[0], arr[i] - 1});
            if(cur[1] - arr[i] > m) set.add(new int[]{arr[i] + 1, cur[1]});
        }

        return -1;
    }
}
