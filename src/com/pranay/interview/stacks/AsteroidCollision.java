package com.pranay.interview.stacks;


import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {10, 2, -5};
        int[] ans = asteroidCollision(asteroids);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] asteroidCollision(int[] a) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if (stack.isEmpty() || a[i] > 0) {
                stack.push(a[i]);
                continue;
            }

            while (true) {
                int prev = stack.peek();
                if (prev < 0) {
                    stack.push(a[i]);
                    break;
                }
                if (prev == -a[i]) {
                    stack.pop();
                    break;
                }
                if (prev > -a[i]) {
                    break;
                }
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(a[i]);
                    break;
                }
            }
        }

        int[] ans = new int[stack.size()];
        for (int t = ans.length - 1; t >= 0; --t) {
            ans[t] = stack.pop();
        }
        return ans;
    }
}
