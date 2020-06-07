package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class ShuffleTheArray {
    public static void main(String[] args) {
        int[] nums = {2,5,1,3,4,7};
        int n = 3;

        int[] ans = shuffle(nums, n);
        System.out.println("Ans : " + Arrays.toString(ans));
    }

    private static int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2*n];
        int ptr = 0;
        for (int i = 0; i<n; i++) {
            arr[ptr++] = nums[i];
            arr[ptr++] = nums[i + n];
        }
        return arr;
    }
}
