package com.pranay.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateInArray {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println("Duplicates : " + duplicates);
    }

    private static List<Integer> findDuplicates(int[] A) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            System.out.println(Arrays.toString(A));
            int idx = Math.abs(A[i])  - 1;
            if (A[idx] < 0)
                ans.add(Math.abs(A[i]));
            A[idx] = -A[idx];
        }
        System.out.println(Arrays.toString(A));
        return ans;
    }
}