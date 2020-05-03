package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class KLengthApart {
    public static void main(String[] args) {
        int[] nums = {1,0,0,1,0,1};
        int k = 2;
        boolean ans = kLengthApart(nums, k);
        System.out.println("Ans : " + ans);
    }

    private static boolean kLengthApart(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i<nums.length; i++) {
            System.out.println(hm);
            if (nums[i] == 1 && hm.containsKey(1)) {
                int pos = hm.get(1);
                hm.put(1, i);
                if (i - pos <= k) {
                    return false;
                }
            } else if (nums[i] == 1) {
                hm.put(1, i);
            }
        }
        return true;
    }
}
