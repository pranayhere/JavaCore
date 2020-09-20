package com.pranay.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1589. Maximum Sum Obtained of Any Permutation
 * https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/
 * https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/discuss/854206/JavaC%2B%2BPython-Sweep-Line
 *
 * Intuition
 * We want to calculate the frequency for A[i].
 * Assign the big element A[i] to the position queried more frequently.
 *
 *
 * Explanation
 * For each request [i,j],
 * we set count[i]++ and count[j + 1]--,
 *
 * Then we sweep once the whole count,
 * we can find the frequency for count[i].
 *
 * Note that for all intervals inputs,
 * this method should be the first intuition you come up with.
 *
 *
 * Complexity
 * Time O(NlogN) for sorting
 * Space O(N)
 */
public class MaxPermutationSum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[][] requests = {{1,3},{0,1}};

        MaxPermutationSum mps = new MaxPermutationSum();
        int sum = mps.maxSumRangeQuery(nums, requests);
        int sum2 = mps.maxSumRangeQueryOptimised(nums, requests);

        System.out.println("Max Sum : " + sum);
    }

    private int maxSumRangeQueryOptimised(int[] nums, int[][] req) {
        int n = nums.length;
        int res = 0;
        int mod = (int)1e9 + 7;

        int[] count = new int[n];
        for (int[] r: req) {
            count[r[0]]++;
            if (r[1] + 1 < n)
                count[r[1] + 1]--;
        }

        for (int i = 1; i < n; i++)
            count[i] += count[i - 1];

        Arrays.sort(nums);
        Arrays.sort(count);

        for (int i = 0; i < n; i++)
            res = (res + nums[i] * count[i]) % mod;

        return res;
    }


    int maxSum = 0;
    int[][] reqs;
    private int maxSumRangeQuery(int[] nums, int[][] requests) {
        reqs = requests;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        for (int n: nums)
            arr.add(n);
        directedPermutations(0, arr, result);
        return maxSum;
    }

    private void directedPermutations(int i, List<Integer> A, List<List<Integer>> result) {
        if (i == A.size() - 1) {
            result.add(new ArrayList<>(A));
            findSum(A);
        }

        for (int j = i; j < A.size(); ++j) {
            Collections.swap(A, i, j);
            directedPermutations(i + 1, A, result);
            Collections.swap(A, i, j);
        }
    }

    private void findSum(List<Integer> list) {
        int sum = 0;
        int[] ps = new int[list.size()];
        ps[0] = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            ps[i] = ps[i - 1] + list.get(i);
        }

        for (int[] q: reqs) {
            int start = q[0];
            int end = q[1];

            int minus = start == 0 ? 0 : ps[start - 1];
            sum += ps[end] - minus;

//                System.out.println(Arrays.toString(q) + "Sum : " + sum);
        }

        maxSum = Math.max(sum, maxSum);
    }
}
