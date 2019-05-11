package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.event.ListSelectionEvent;

public class GreedyMaxMin {
	public static void main(String[] args) {
		int k = 3;
		int[] arr = {100, 200, 300, 350, 400, 401, 402};
		int minimumUnfairness = minMax(k, arr);
		System.out.println("Minimum Unfairness : " + minimumUnfairness);
	}

	private static int minMax(int k, int[] arr) {
		int minUnfairness = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for (int i=0; i<=arr.length-k; i++) {
			int unfairness = arr[i+k-1] - arr[i];
			if (unfairness < minUnfairness) {
				minUnfairness = unfairness;
			}
		}
		return minUnfairness;
	}
	
	
}
