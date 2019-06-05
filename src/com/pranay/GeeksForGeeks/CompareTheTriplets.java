package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.hackerrank.com/challenges/compare-the-triplets/problem

public class CompareTheTriplets {

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(new Integer[]{5, 6, 7}); 
		List<Integer> b = Arrays.asList(new Integer[]{3, 6, 10});
		
		List<Integer> result = compareTriplets(a, b);
		System.out.println(result);
	}

	private static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		int alice = 0;
		int bob = 0;
		for(int i=0; i<a.size(); i++) {
			int aliceScore = a.get(i);
			int bobScore = b.get(i);
			if (aliceScore > bobScore)
				alice++;
			else if (aliceScore < bobScore)
				bob++;
			else
				continue;
		}
		return Arrays.asList(new Integer[] {alice, bob});
	}

}
