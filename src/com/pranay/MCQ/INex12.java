package com.pranay.MCQ;

import java.util.Stack;

public class INex12 {
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push("A");
		s.push("B");
		s.push(s);
		while(!s.isEmpty()) {
			Object obj = s.pop();
			if(obj instanceof Stack) {
				System.out.println("here1");
				while(!((Stack) obj).isEmpty()) {
					System.out.println(((Stack)obj).pop());
				}
			}else {
				System.out.println("here");
				System.out.println(obj);
			}
		}
	}
}
