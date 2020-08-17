package com.pranay.interview.searching;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;

        int minSum = splitArray2(nums, m);
        System.out.println("Min Sum : " + minSum);
    }

    private static int splitArray(int[] nums, int M) {
        long l = Integer.MAX_VALUE;
        long r = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            r += nums[i];
            if (l > nums[i]) {
                l = nums[i];
            }
        }
        long ans = r;
        while (l <= r) {
            long mid = (l + r) >> 1;
            long sum = 0;
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                if (sum + nums[i] > mid) {
                    cnt ++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            if (cnt <= M) {
                ans = Math.min(ans, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)ans;
    }


    private static int splitArray2(int[] nums, int M) {
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int n: nums) {
            sum += n;
            min = Math.min(min, n);
        }

        int lo = min;
        int hi = sum;

        while (lo < hi) {
            int targetSum = lo + (hi - lo) / 2;

            int currSum = 0;
            int chunks = 1;

            for (int i = 0; i < nums.length; i++) {
                currSum += nums[i];

                if (currSum > targetSum) {
                    chunks++;
                    currSum = nums[i];
                }
            }

            if (chunks > M)
                lo = targetSum + 1;
            else
                hi = targetSum - 1;
        }
        return lo;
    }
}
