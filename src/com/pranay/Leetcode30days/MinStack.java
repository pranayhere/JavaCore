package com.pranay.Leetcode30days;

import java.util.Stack;

public class MinStack {
	Stack<Integer> stk;
	Stack<Integer> minStk;

	public MinStack() {
		stk = new Stack<>();
		minStk = new Stack<>();
	}

	public void push(int x) {
		stk.push(x);
		if (!minStk.isEmpty() && minStk.peek() < x) {
			minStk.push(minStk.peek());
		} else {
			minStk.push(x);
		}
	}

	public void pop() {
		stk.pop();
		minStk.pop();
	}

	public int top() {
		return stk.peek();
	}

	public int getMin() {
		return minStk.peek();
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
}
