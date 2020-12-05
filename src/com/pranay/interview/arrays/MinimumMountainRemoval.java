package com.pranay.interview.arrays;

public class MinimumMountainRemoval {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,3,2,1};
        int minRemovals = minimumMountainRemovals(nums);
        System.out.println("Minimum Removals : " + minRemovals);
    }

    public static int minimumMountainRemovals(int[] nums) {
        int peek = -1;
        int ans = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] <= nums[i] && nums[i] >= nums[i + 1]) {
                peek = i;
                int minIncRemovals = minIncreasingRemove(nums, peek);
                int minDecRemovals = minDecreasingRemove(nums, peek + 1);
                System.out.println("Peek : " + peek + " removals(inc) :  " +minIncRemovals + " removals(dec) : " + minDecRemovals);

                ans = Math.min(ans, minIncRemovals + minDecRemovals);

                if (nums[i] == nums[i + 1])
                    ans++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    private static int minDecreasingRemove(int[] nums, int start) {
        int n = nums.length;
        if (n - start == 1)
            return 0;

        int LDS[] = new int[n];
        int len = 0;

        // Mark all elements of LIS as 1
        for (int i = 0; i < n; i++)
            LDS[i] = 1;

        for (int i = start + 1; i < n; i++) {
            for (int j = start; j < i; j++) {
                if (nums[i] < nums[j] && LDS[i] < LDS[j] + 1)
                    LDS[i] = LDS[j] + 1;
            }
            len = Math.max(len, LDS[i]);
        }

        return n - start - len;
    }

    public static int minIncreasingRemove(int arr[], int n)
    {
        if (n == 1)
            return 0;

        int LIS[] = new int[n];
        int len = 0;

        // Mark all elements of LIS as 1
        for (int i = 0; i < n; i++)
            LIS[i] = 1;

        // Find LIS of array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && (i-j)<=(arr[i]-arr[j]))
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
            }
            len = Math.max(len, LIS[i]);
        }

        // Return min changes for array
        // to strictly increasing
        return n - len;
    }
}
