package com.pranay.interview.arrays;

import java.util.Arrays;

public class FirstMissing {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 4, -10};
        int num = firstMissing(arr);
        System.out.println("first missing : " + num);
    }

    private static int firstMissing(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            int cur = nums[i];
            if (cur >= 1 && cur <= nums.length && cur != nums[cur - 1]) {
                nums[i] = nums[cur - 1];
                nums[cur - 1] = cur;
                continue;
            }
            i++;
        }

        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }
}