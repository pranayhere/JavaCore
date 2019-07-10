package com.pranay.GeeksForGeeks;

import java.util.Arrays;

// https://leetcode.com/problems/distribute-candies-to-people/submissions/

public class DistributeCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int candies = 81;
		int num_ppl = 5;
		
		int arr[] = distributeCandies(candies, num_ppl);
		System.out.println(Arrays.toString(arr));
	}

	private static int[] distributeCandies(int candies, int num_ppl) {
		int[] people  = new int[num_ppl];
		for (int give = 0; candies > 0; candies -= give) {
			people[give % num_ppl] += Math.min(candies, ++give);
			System.out.println("arr loc : " + ((give-1) % num_ppl) + " candies : "+ candies + " give :  " + give+ " arr : " + Arrays.toString(people));
		}
		return people;
	}

}
