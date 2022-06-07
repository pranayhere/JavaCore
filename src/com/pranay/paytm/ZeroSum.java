package com.pranay.paytm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * input= [1,2,-3,3,2,1]
 * output - [3,2,1] or [1,2,2,1]
 *
 * consecutive zero sum
 *
 * [1, 3, 0, 3, 5, 6]
 * [6, 5, 3, 6, 3, 1]
 *
 * sweep line
 * Map<sum, index>
 * 0          0     <-
 *    1
 *
 *        3       3     <-
 *
 *                     5
 *                         6
 */
public class ZeroSum {
    public static void main(String[] args) {
        int[] nums = {1,2,-3,3,2,1};
        ZeroSum zs = new ZeroSum();
        List<Integer> ans = zs.removeZeroSum(nums);
        System.out.println(ans);
    }

    private List<Integer> removeZeroSum(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int sum = 0;
        List<int[]> remove = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hm.containsKey(sum)) {
                   remove.add(new int[]{i, hm.get(sum)});
            } else {
                hm.put(sum, i);
            }
        }

        System.out.println(hm);
        for (int[] r: remove)
            System.out.println(Arrays.toString(r));

        return null;
    }
}
