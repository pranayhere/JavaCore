package com.pranay.interview.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/confusing-number-ii/
 *
 * We can rotate digits by 180 degrees to form new digits.
 * When 0, 1, 6, 8, 9 are rotated 180 degrees, they become 0, 1, 9, 8, 6 respectively.
 * When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid.
 *
 * A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.
 * (Note that the rotated number can be greater than the original number.)
 *
 * Given a positive integer N, return the number of confusing numbers between 1 and N inclusive.
 *
 * Example 1:
 *
 * Input: 20
 * Output: 6
 * Explanation:
 * The confusing numbers are [6,9,10,16,18,19].
 * 6 converts to 9.
 * 9 converts to 6.
 * 10 converts to 01 which is just 1.
 * 16 converts to 91.
 * 18 converts to 81.
 * 19 converts to 61.
 */
public class ConfusingNumber2 {
    public static void main(String[] args) {
        int n = 2000;
        ConfusingNumber2 cn2 = new ConfusingNumber2();
        int count = cn2.confusingNumberII(n);
        System.out.println("Confusing Numbers : " + count);
    }

    Map<Integer, Integer> hm = new HashMap<>();
    int[] nums = {0, 1, 6, 8, 9};

    int count = 0;
    int N;

    private int confusingNumberII(int n) {
        N = n;
        hm.put(0, 0);
        hm.put(1, 1);
        hm.put(6, 9);
        hm.put(8, 8);
        hm.put(9, 9);


        dfs(0);
        return count;
    }

    private void dfs(long start) {
        System.out.println(start);
        if (start > N)
            return;

        if (isConfusing(start)) {
            count++;
        }

        for (int i = start == 0 ? 1 : 0; i<5; i++) {
            if (start * 10 + nums[i] <= N)
                dfs(start * 10 + nums[i]);
        }
    }

    private boolean isConfusing(long s) {
        long res = 0, x = s;
        while (x > 0) {
            int i = (int) (x % 10);
            long digit = hm.get(i);
            res = res * 10 + digit;
            x = x / 10;
        }
        return res != s;
    }
}
