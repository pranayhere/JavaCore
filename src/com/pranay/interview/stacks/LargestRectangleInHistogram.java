package com.pranay.interview.stacks;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        int maxArea = largestRectangleArea(heights);
        System.out.println("Max area : " + maxArea);
    }

    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int maxArea = 0;
        int area = 0;
        int i;
        for (i = 0; i < heights.length;) {
            if (stk.isEmpty() || heights[stk.peek()] <= heights[i]) {
                stk.push(i);
                i++;
            } else {
                int top = stk.pop();

                if (stk.isEmpty()) {
                    area = heights[top] * i;
                } else {
                    area = heights[top] * (i - stk.peek() - 1);
                }

                maxArea = Math.max(maxArea, area);
            }
        }

        while (!stk.isEmpty()) {
            int top = stk.pop();
            if (stk.isEmpty()) {
                area = heights[top] * i;
            } else {
                area = heights[top] * (i - stk.peek() - 1);
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}