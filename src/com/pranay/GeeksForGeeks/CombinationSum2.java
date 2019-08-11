package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/
// This is same as combinationSum problem
// In this we are increasing startIndex every time because we want coins to be different in a combination. i.e. [1, 1] is invalid

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> list = combinationSum(candidates, target);
        System.out.println(list);
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);

        List<Integer> combinations = new ArrayList<>();

        result = getCombinations(combinations, result, candidates, target, 0);
        return result;
    }

    private static List<List<Integer>> getCombinations(List<Integer> combinations, List<List<Integer>> result, int[] candidates, int target, int startIndex) {
        System.out.println(combinations);
        if (target == 0) {
            result.add(new ArrayList<>(combinations));
        }

        if (target < 0) {
            return result;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i == startIndex || candidates[i] != candidates[i - 1]) {
                combinations.add(candidates[i]);
                result = getCombinations(combinations, result, candidates, target - candidates[i], i + 1);
                combinations.remove(combinations.size() - 1);
            }
        }
        return result;
    }
}
