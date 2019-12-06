package com.pranay.GeeksForGeeks;

import java.util.Arrays;
import java.util.List;

public class CalculateRegion {
	public static void main(String[] args) {
		List<Integer> heights = Arrays.asList(1,1,1,1);
		long region = calculateTotalRegion(heights);
		System.out.println(region);
	}

	public static long calculateTotalRegion(List<Integer> heights) {
		int region = 0;
		for (int i = 0; i<heights.size(); i++) {
			int left = i-1;
			int right = i+1;

			while (left >= 0 && heights.get(left) <= heights.get(i)) {
				left--;
			}
			left++;

			while (right < heights.size() && heights.get(right) <= heights.get(i)) {
				right++;
			}
			right--;

			region += right - left + 1;
		}
		return region;
	}
}
