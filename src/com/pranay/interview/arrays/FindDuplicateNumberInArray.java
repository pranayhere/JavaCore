package com.pranay.interview.arrays;

import java.util.Arrays;

public class FindDuplicateNumberInArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 2};
        int duplicate = findDuplicate(arr);
        System.out.println("Duplicate : " + duplicate);
    }

    private static int findDuplicate(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i<arr.length; i++) {
            if (arr[i-1] == arr[i]) {
                return arr[i];
            }
        }
        return -1;
    }

}
