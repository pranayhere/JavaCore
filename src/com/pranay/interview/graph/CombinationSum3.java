package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 * https://leetcode.com/problems/combination-sum-iii/
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        int k = 3, n = 9;
        CombinationSum3 cs3 = new CombinationSum3();
        List<List<Integer>> ans = cs3.combinationSum3(k, n);
        System.out.println("Ans : " + ans);
    }

    int K;
    int N;
    private List<List<Integer>> combinationSum3(int k, int n) {
        K = k;
        N = n;

        List<List<Integer>> ans = new ArrayList<>();
        dfs(1, new ArrayList<>(), ans, 0);
        return ans;
    }

    public void dfs(int i, List<Integer> curr, List<List<Integer>> ans, int currSum) {
        if (currSum > N)
            return;

        if (currSum == N && curr.size() == K) {
            ans.add(new ArrayList<>(curr));
        }

        for (;i < 10; i++) {
            currSum += i;
            curr.add(i);
            dfs(i + 1, curr, ans, currSum);
            currSum -= i;
            curr.remove(curr.size() - 1);
        }
    }
}
