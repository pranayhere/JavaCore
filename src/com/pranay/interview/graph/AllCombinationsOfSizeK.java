package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllCombinationsOfSizeK {
    public static void main(String[] args) {
        List<String> arr = Arrays.asList("a", "b", "c", "d", "e");
        int k = 3;
        List<List<String>> allCombo = combinations(arr, k);
        System.out.println(allCombo);
    }

    private static List<List<String>> combinations(List<String> arr, int k) {
        List<List<String>> res = new ArrayList<>();
        dfs(arr, 0, new ArrayList<>(), res, k);
        return res;
    }

    private static void dfs(List<String> arr, int idx, ArrayList<String> curr, List<List<String>> res, int k) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = idx; i<arr.size(); i++) {
            curr.add(arr.get(i));
            dfs(arr, i + 1, curr, res, k);
            curr.remove(curr.size() - 1);
        }
    }
}