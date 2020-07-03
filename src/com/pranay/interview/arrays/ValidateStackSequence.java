package com.pranay.interview.arrays;

import java.util.Stack;

public class ValidateStackSequence {
    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {5, 4, 3, 2, 1};

        ValidateStackSequence vss = new ValidateStackSequence();
        boolean isValid = vss.validateStackSequences(pushed, popped);
        System.out.println("Is Valid : " + isValid);
    }

    Stack<Integer> stk = new Stack<>();

    private boolean validateStackSequences(int[] pushed, int[] popped) {
        int ptr = 0;

        for (int x : pushed) {
            stk.push(x);
            while (!stk.isEmpty() && ptr < pushed.length && popped[ptr] == stk.peek()) {
                stk.pop();
                ptr++;
            }
        }

        return ptr == pushed.length;
    }
}
