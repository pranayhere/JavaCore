package com.pranay.interview.graph;

/**
 * 1537. Get the Maximum Score
 * https://leetcode.com/problems/get-the-maximum-score/
 *
 * Intuition
 * We must take the common elements and won't miss them;
 * And there will be two path between the common elements,
 * and we will take and only take one path.
 *
 * We calculate the sum of both path, and take the bigger one.
 *
 *
 * Explanation
 * So we apply two points solutions,
 * and always take the step in the smaller element.
 *
 * If two elements are the same,
 * we compare the accumulated sum in the both paths,
 * and we pick the bigger one.
 *
 *
 * Complexity
 * Time O(N)
 * Space O(1)
 */
public class GetMaxScore {
    public static void main(String[] args) {
        int[] nums1 = {2, 4, 5, 8, 10};
        int[] nums2 = {4, 6, 8, 9};

        int score = maxSum(nums1, nums2);
        System.out.println("Score : " + score);
    }

    private static int maxSum(int[] A, int[] B) {
        int i = 0;
        int j = 0;
        int n = A.length;
        int m = B.length;

        long a = 0;
        long b = 0;
        long res = 0;
        long mod = (long) 1e9 + 7;

        while (i < n || j < m) {
            if (i < n && (j == m || A[i] < B[j])) {
                a += A[i];
                i++;
            } else if (j < m && (i == n || A[i] > B[j])) {
                b += B[j];
                j++;
            } else {
                res += Math.max(a, b) + A[i];
                i++;
                j++;
                a = 0;
                b = 0;
            }
        }
        return (int) ((res + Math.max(a, b)) % mod);
    }
}
