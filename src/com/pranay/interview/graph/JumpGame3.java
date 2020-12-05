package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.List;

public class JumpGame3 {
    public static void main(String[] args) {
        int[] arr = {3,0,2,1,2};
        int start = 2;

        JumpGame3 jg3 = new JumpGame3();
        boolean ans = jg3.canReach(arr, start);
        System.out.println("ANS : " + ans);
    }

    public boolean canReach(int[] arr, int curr) {
        return dfs(arr, curr, new boolean[arr.length]);
    }

    public boolean dfs(int[] arr, int curr, boolean[] seen) {
        if (curr < 0 || curr >= arr.length || seen[curr])
            return false;

        if (arr[curr] == 0)
            return true;

        seen[curr] = true;

        return dfs(arr, curr + arr[curr], seen) || dfs(arr, curr - arr[curr], seen);
    }
}
