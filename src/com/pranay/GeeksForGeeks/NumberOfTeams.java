package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfTeams {
	public static void main(String[] args) {
		int[] rating = {2,5,3,4,1};
		int count = numTeams(rating);
		System.out.println(count);
	}

	private static int numTeams(int[] rating) {
		int n = rating.length;
		int[] biggerRight = new int[n];
		int[] biggerLeft = new int[n];
		int ans = 0;

		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (rating[i] < rating[j])
					biggerRight[i]++;
				else if (rating[i] > rating[j])
					biggerLeft[j]++;

		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (rating[i] < rating[j])
					ans += biggerRight[j];
				else if (rating[i] > rating[j])
					ans += biggerLeft[i];

		return ans;
	}
}
