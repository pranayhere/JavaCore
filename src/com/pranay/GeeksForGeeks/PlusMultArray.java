package com.pranay.GeeksForGeeks;

import java.util.Arrays;
import java.util.List;

public class PlusMultArray {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(new Integer[] {12, 3, 5, 7, 13, 12 });
		String ans = plusMult(list);
	}

	public static String plusMult(List<Integer> list) 
	{
		int rEven = r(list, 0) % 2;
		int rOdd = r(list, 1) % 2;
	
		System.out.println(rEven + " " +rOdd);
		if (rOdd > rEven) return "ODD";
		else if (rOdd < rEven) return "EVEN";
		else return "NEUTRAL";
	}
	
	private static int r(List<Integer> list, int index) {
		boolean add = false;
		int r = list.get(index);
		for (int i = index+2; i<list.size(); i=i+2) {
			if (add == true) {
				r += list.get(i);
			} else {
				r = r * list.get(i);
			}
			add = !add;
		}
		return r;
	}
	
}
