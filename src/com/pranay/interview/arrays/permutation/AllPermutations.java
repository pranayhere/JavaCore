package com.pranay.interview.arrays.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPermutations {
    public static void main(String[] args) {
        int n = 3;
        List<List<Integer>> allPermutations = generateAllPermutations(n);
        System.out.println(allPermutations);
    }

    private static List<List<Integer>> generateAllPermutations(int n) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        directedPermutations(0, list, res);
        return res;
    }

    private static void directedPermutations(int i, List<Integer> A, List<List<Integer>> res) {
        if (i == A.size() - 1)
            res.add(new ArrayList<>(A));

        for (int j = i; j < A.size(); ++j) {
            Collections.swap(A, i, j);
            directedPermutations(i+1, A, res);
            Collections.swap(A, i, j);
        }
    }
}
