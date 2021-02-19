package com.pranay.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestHarmoniousSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
//        int[] nums = {1,2,3,4};
//        int[] nums = {1,1,1,1};

        int ans = findLHS(nums);
        System.out.println("Ans : " + ans);
    }

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int k: map.keySet()) {
            if (map.containsKey(k - 1)) {
                ans = Math.max(ans, map.get(k) + map.get(k - 1));
            }
        }

        return ans;
    }
}
