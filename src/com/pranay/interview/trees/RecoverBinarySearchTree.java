package com.pranay.interview.trees;

import java.util.Arrays;
import java.util.List;

public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,4,2);
        int[] arr = findTwoSwapped(list);
        System.out.println(Arrays.toString(arr));
    }

    private static int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        for (int i = 0; i<n-1; i++) {
            if (nums.get(i+1) < nums.get(i)) {
                y = nums.get(i+1);
                if (x == -1)
                    x = nums.get(i);
                else
                    break;
            }
        }
        return new int[]{x, y};
    }
}
