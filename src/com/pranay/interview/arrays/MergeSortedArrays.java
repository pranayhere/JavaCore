package com.pranay.interview.arrays;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {0,0,0};
        int m = 0;

        int[] nums2 = {2,5,6};
        int n = 3;

        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int right = nums1.length - 1;

        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[right] = nums1[m - 1];
                m--;
            } else {
                nums1[right] = nums2[n - 1];
                n--;
            }
            right--;
        }
        System.arraycopy(nums2, 0, nums1, 0, n);
//        System.out.println(Arrays.toString(nums1));
    }
}
