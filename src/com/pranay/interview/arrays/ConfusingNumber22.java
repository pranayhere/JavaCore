package com.pranay.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class ConfusingNumber22 {
    public static void main(String[] args) {
        int n = 2000;
        ConfusingNumber22 cn = new ConfusingNumber22();
        int count = cn.confusingNumberII(n);
        System.out.println("Confusing Numbers : " + count);
    }

    private int[] nums = {0, 1, 6, 8, 9};
    private Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    int limit;

    private int confusingNumberII(int N) {
        limit = N;
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(8, 8);
        map.put(9, 6);

        dfs(0, 0, 1);
        return count;
    }

    private void dfs(long num, long rotatedNum, int base) {
        if (num > limit)
            return;

        System.out.println(num + " - " + rotatedNum);
        if (num != rotatedNum)
            count++;

        for (int d : nums) {
            if (num == 0 && d == 0) continue;
            dfs(num * 10 + d, map.get(d) * base + rotatedNum, base * 10);
        }
    }
}
