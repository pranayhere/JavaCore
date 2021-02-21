package com.pranay.interview.arrays;

public class ArrayByConcatSubarray {
    public static void main(String[] args) {
        int[][] groups = {{1, -1, -1}, {3, -2, 0}};
        int[] nums = {1, -1, 0, 1, -1, -1, 3, -2, 0};

        boolean ans = canChoose(groups, nums);
        System.out.println("Ans : " + ans);
    }

    private static boolean canChoose(int[][] groups, int[] nums) {
        int idx = 0;
        for (int[] g : groups) {
            int endAt = isSubArray(nums, g, idx);
            System.out.println(endAt);
            if (endAt == -1)
                return false;
            else
                idx = endAt;
        }
        return true;
    }

    public static int isSubArray(int[] A, int[] B, int startAt) {
        int n = A.length;
        int m = B.length;

        int i = startAt, j = 0;
        while (i < n && j < m) {
            if (A[i] == B[j]) {
                i++;
                j++;
                if (j == m)
                    return i;
            }
             else {
                i = i - j + 1;
                j = 0;
            }
        }
        return -1;
    }
}
