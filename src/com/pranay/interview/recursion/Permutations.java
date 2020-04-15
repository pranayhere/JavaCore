package com.pranay.interview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		List<List<Integer>> ans = permutations(list);
		System.out.println(ans);
	}

	private static List<List<Integer>> permutations(List<Integer> list) {
		List<List<Integer>> result = new ArrayList<>();
		directedPermutations(0, list, result);
		return result;
	}

	private static void directedPermutations(int i, List<Integer> A, List<List<Integer>> result) {
		if (i == A.size() - 1) {
			result.add(new ArrayList<>(A));
		}

		for (int j = i; j < A.size(); ++j) {
			Collections.swap(A, i, j);
			directedPermutations(i + 1, A, result);
			Collections.swap(A, i, j);
		}
	}
}
