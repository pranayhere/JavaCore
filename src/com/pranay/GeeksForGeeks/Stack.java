package com.pranay.GeeksForGeeks;

public class Stack {
	private char arr[];
	private int top;
	private int size;
	
	public Stack(int size) {
		this.size = size;
		top = -1;
		arr = new char[size];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top >= size-1);
	}
	
	public void push(char ch) {
		if(isFull()) {
			System.out.println("Stack overflow");
			return;
		}
		arr[++top] = ch;
	}
	
	public char pop() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
			return '$';
		}
		return arr[top--];
	}
}
