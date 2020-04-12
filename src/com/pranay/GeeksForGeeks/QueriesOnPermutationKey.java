package com.pranay.GeeksForGeeks;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class QueriesOnPermutationKey {
	public static void main(String[] args) {
		int[] queries = {3,1,2,1};
		int m = 5;
		int[] res = processQueries(queries, m);
		System.out.println(Arrays.asList(res));
	}

	private static int[] processQueries(int[] queries, int m) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i<=m; i++) {
			list.addLast(i);
		}

		int result[] = new int[queries.length];
		for (int i=0; i<queries.length; i++) {
			int idx = list.indexOf(queries[i]);
			result[i] = idx;
			list.remove(idx);
			list.addFirst(queries[i]);
		}

		return result;
	}
}
