package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SteppingNumbers {
	public static void main(String[] args) {
		int low = 10;
		int high = 15;
//		List<Integer> ans = countSteppingNumbers(low, high);
		List<Integer> ans2 = countSteppingNumbersDfs(low, high);
//		System.out.println(ans.toString());
		System.out.println(ans2.toString());

	}

	public static List<Integer> countSteppingNumbers(int s, int e) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int i = 0;
		while (s <= e) {
			if (isStepNum(s)) {
				res.add(s);
			}
			s++;
		}
		return res;
	}

	public static boolean isStepNum(int i) {
		if (i >= 0 && i <= 9) return true;
		while (i >= 10) {
			if (Math.abs(i % 10 - (i / 10) % 10) != 1) { // compare last two digits
				return false;
			}
			i = i / 10;
		}
		return true;
	}
	public static List<Integer> countSteppingNumbersDfs(int low, int high) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0 ; i <= 9 ; i++)
			dfs(low, high, i, list);
		return list;
	}

	public static void dfs(int low,int high, long stepNum, List<Integer> list)
	{
		if (stepNum <= high && stepNum >= low) list.add((int)stepNum);

		if (stepNum == 0 || stepNum > high) return;

		long lastDigit = stepNum % 10;
		long stepNumA = stepNum*10 + (lastDigit-1);
		long stepNumB = stepNum*10 + (lastDigit+1);
		if (lastDigit == 0) dfs(low, high, stepNumB, list);
		else if(lastDigit == 9) dfs(low, high, stepNumA, list);
		else {
			dfs(low, high, stepNumA, list);
			dfs(low, high, stepNumB, list);
		}
	}


//	public static void dfs(int low, int high, long cur, List<Integer> list) {
//		if (cur >= low && cur <= high) list.add((int)cur);
//		if (cur == 0 || cur > high) return;
//
//		long last = cur%10, inc = cur*10 + last + 1, dec = cur*10 + last - 1;
//
//		if (last == 0) dfs(low, high, inc, list);
//		else if (last == 9) dfs(low, high, dec, list);
//		else {
//			dfs(low, high, inc, list);
//			dfs(low, high, dec, list);
//		}
//	}


	public static void bfs(int n,int m,int num, List<Integer> list)
	{
		Queue<Integer> q = new LinkedList<>();
		q.add(num);

		while (!q.isEmpty())
		{
			int stepNum = q.poll();
			if (stepNum <= m && stepNum >= n)
			{
				list.add(stepNum);
			}
			if (stepNum == 0 || stepNum > m)
				continue;
			int lastDigit = stepNum % 10;

			int stepNumA = stepNum * 10 + (lastDigit- 1);
			int stepNumB = stepNum * 10 + (lastDigit + 1);

			if (lastDigit == 0)
				q.add(stepNumB);

			else if (lastDigit == 9)
				q.add(stepNumA);

			else
			{
				q.add(stepNumA);
				q.add(stepNumB);
			}
		}
	}
}
