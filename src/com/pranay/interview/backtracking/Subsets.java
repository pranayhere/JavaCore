package com.pranay.interview.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }

    private static List<List<Integer>> subsets(int[] A) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(A);
        dfs(list, new ArrayList<>(), A, 0);
        return list;
    }

    private static void dfs(List<List<Integer>> list, ArrayList<Integer> curr, int[] A, int start) {
        list.add(new ArrayList<>(curr));
        for (int i = start; i < A.length; i++) {
            curr.add(A[i]);
            dfs(list, curr, A, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}