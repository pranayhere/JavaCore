package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LuckBalance {
	public static void main(String[] args) {
		int k = 3;
		int[][] contest = {
				{5,1},
				{2,1},
				{1,1},
				{8,1},
				{10,0},
				{5,0}
		};
		
		int maxLuck = luckBalance(k, contest);
		System.out.println(maxLuck);
	}

	private static int luckBalance(int k, int[][] contest) {
		List<Integer> sortedList = new ArrayList<>(); 
		int count = 0;
		int sum = 0;
		for (int i=0; i<contest.length; i++) {
			sum += contest[i][0];
			if (contest[i][1] == 1) {
				sortedList.add(contest[i][0]);				
				count++;
			}
		}
		Collections.sort(sortedList);
		for (int i=0; i<(count - k); i++) {
			sum -= 2 * sortedList.get(i);
		}
		return sum;
	}
}
