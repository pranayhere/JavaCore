package com.pranay.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysRemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		String[] words = {"Geeks", "for", "Geeks", "GeeksQuiz", "for", "GeeksforGeeks"};
		printDistinct(nums, words);
	}

	private static void printDistinct(int[] nums, String[] words) {
		System.out.println("Count distinct elements in an Array");
		System.out.println(Arrays.stream(nums).distinct().count());
		System.out.println(Arrays.stream(words).distinct().count());
		
		System.out.println("Print distinct elements in an Array");
		Arrays.stream(nums).distinct().forEach(System.out::print);
		Arrays.stream(words).distinct().forEach(System.out::print);

		System.out.println("\nConvert Array to List");
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		List<String> wordsList = Arrays.asList(words);
		System.out.println(list);
		System.out.println(wordsList);
	}
}
