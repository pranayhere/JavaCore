package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.List;

public class HackerCards {
	public static void main(String[] args) {
		int d = 5;
		List<Integer> collection = new ArrayList<Integer>();
		collection.add(1);
		collection.add(2);
		collection.add(3);
		collection.add(4);
		
		List<Integer> list = hackerCards(collection, d);
		System.out.println(list);
	}

	private static List<Integer> hackerCards(List<Integer> collection, int d) {
		List<Integer> ans = new ArrayList<Integer>();
		for (int i=1; i<=d; i++) {
			if(collection.contains(i)) {
				continue;
			}
			if (d - i > -1) {
				ans.add(i);
			}
			d -= i;
		}
		
		return ans;
	}
}
