package com.pranay.GeeksForGeeks;

import java.util.Arrays;

// https://leetcode.com/problems/trapping-rain-water/

public class TrappingRainWater {
	
	public static void main(String[] args) {
		int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
		int water = trap(height);
		System.out.println(water);
	}

	private static int trap(int[] height) {
		if (height.length < 2) {
            return 0;
        }
		
		int leftMax[] = new int[height.length];
		int rightMax[] = new int[height.length];
		int water = 0;
		
		leftMax[0] = height[0];
		for (int i = 1; i<height.length; i++) {
			leftMax[i] = Math.max(height[i], leftMax[i-1]);
		}
		
		System.out.println(Arrays.toString(leftMax));
		
		rightMax[height.length - 1] = height[height.length - 1];
		for (int i = height.length - 2; i>=0; i--) {
			rightMax[i] = Math.max(height[i], rightMax[i+1]);
		}

		System.out.println(Arrays.toString(rightMax));
		
		for (int i=0; i<height.length; i++) {
			water = water + Math.min(leftMax[i], rightMax[i]) - height[i];
		}
		
		return water;
	}
}
