package com.pranay.GeeksForGeeks;

// https://leetcode.com/problems/container-with-most-water/submissions/

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {1,8,6,2,5,4,8,3,7};
		int water = maxArea(height);
		System.out.println("Water : " + water);
	}

	private static int maxArea(int[] height) {
		int low = 0;
		int high = height.length-1;
		int maxWater = 0;
		while (low < high) {
//			System.out.println(height[low] + " - " +height[high]);
			int currentWater = Math.min(height[high], height[low]) * (high - low);
			maxWater = Math.max(currentWater, maxWater);
//			System.out.println("Current : " +currentWater+ " - maxWater : "+ maxWater);
			if (height[low] <= height[high])
				low++;
			else
				high--;
		}
		return maxWater;
	}

}
