package com.pranay.GeeksForGeeks;

import java.util.Arrays;
import java.util.Stack;
import java.util.Comparator; 

class Interval1 {
	int start, end;
	public Interval1(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class MergingOverlappingIntervals {

	public static void main(String[] args) {
		Interval1 arr[] = new Interval1[4];
		arr[0] = new Interval1(1,3);
		arr[1] = new Interval1(2,6);
		arr[2] = new Interval1(8,10);
		arr[3] = new Interval1(15,18); 
		mergeIntervals(arr);
	}

	private static void mergeIntervals(Interval1[] arr) {
		if (arr.length <= 0)
			return;
		
		Stack<Interval1> stack = new Stack<>();
		Arrays.sort(arr, new Comparator<Interval1>(){

			@Override
			public int compare(Interval1 o1, Interval1 o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
		});
		
		stack.push(arr[0]);
		
		for (int i=1; i<arr.length; i++) {
			Interval1 top = stack.peek();
			if (top.end < arr[i].start)
				stack.push(arr[i]);
			else if (top.end < arr[i].end) {
				top.end = arr[i].end;
				stack.pop();
				stack.push(top);
			}
		}
		
		while(!stack.isEmpty()) {
			Interval1 t = stack.pop();  
            System.out.print("["+t.start+","+t.end+"] ");
		}
	}
}