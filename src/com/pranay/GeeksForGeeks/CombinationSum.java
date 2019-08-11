package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum/

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {1, 2, 5};
        int target = 11;

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

        for(int i = startIndex; i<candidates.length; i++) {
            combinations.add(candidates[i]);
            result = getCombinations(combinations, result, candidates, target - candidates[i], i);
            combinations.remove(combinations.size() - 1);
        }
        return result;
    }
}
