package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class MaxScoreWords {
	public static void main(String[] args) {
		String[] words = {"dog","cat","dad","good"};
		String[] letters = {"a","a","c","d","d","d","g","o","o"};
		int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};

		int count = maxScoreWords(words, letters, score);
		System.out.println(count);
	}

	private static int maxScoreWords(String[] words, String[] letters, int[] score) {
		int[] nums = new int[words.length];

		for (int i=0; i<words.length; i++) {
			char[] arr = words[i].toCharArray();
			int sum = 0;
			for (char ch: arr) {
				sum += score[ch - 'a'];
			}
			nums[i] = sum;
		}
		System.out.println(Arrays.toString(nums));
		return 0;
	}

}
