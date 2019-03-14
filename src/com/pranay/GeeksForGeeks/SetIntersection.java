package com.pranay.GeeksForGeeks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetIntersection {

	public static void main(String[] args) {
		String s1 = "Hi";
		String s2 = "World";

		String ans = twoStrings(s1, s2);
		System.out.println(ans);
	}

	private static String twoStrings(String s1, String s2) {
		Set set1 = new HashSet(Arrays.asList(s1.split("")));
		Set set2 = new HashSet(Arrays.asList(s2.split("")));
		set1.retainAll(set2);
		
		if(set1.size() == 0)
			return "NO";
		return "YES";
	}
}