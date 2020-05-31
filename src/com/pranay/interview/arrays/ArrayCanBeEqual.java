package com.pranay.interview.arrays;

import java.util.Arrays;
// https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/

public class ArrayCanBeEqual {
    public static void main(String[] args) {
        int[] target = {1,2,3,4};
        int[] arr = {2,4,1,3};
        boolean ans = canBeEqual(target, arr);
        System.out.println(ans);
    }

    private static boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }

        Arrays.sort(target);
        Arrays.sort(arr);

        for (int i = 0; i<target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}
