package com.pranay.interview.arrays;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = dailyTemperatures(temp);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] dailyTemperatures(int[] T) {
        Stack<Integer> stk = new Stack<>();
        int ans[] = new int[T.length];

        for (int i = T.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && T[i] >= T[stk.peek()])
                stk.pop();
            ans[i] = stk.isEmpty() ? 0 : stk.peek() - i;
            stk.push(i);
        }
        return ans;
    }
}
