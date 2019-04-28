package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SherlockAndValidString {

	public static void main(String[] args) {
		String str = "abcdefghhgfedecba";
		String res = isValid(str); 
		System.out.println(res);
	}

	private static String isValid(String str) {
		int[] freq = new int[26];
		
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			freq[ch - 'a']++;
		}
		Arrays.sort(freq);
		int i = 0;
		while(freq[i] == 0)
			i++;
		
		int min = freq[i];
		int max = freq[25];
		
		if(min == max)
			return "GOOD";
		else {
			if((max-min == 1 && max > freq[24]) || (min == 1 && freq[i+1] == max)) {
				return "GOOD";
			}
		}
		return "BAD";
	}
}
