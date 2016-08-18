package com.pranay.MCQ;

import java.util.ArrayList;
import java.util.List;

public class INex13 {
	public static void main(String[] args) {
		List<String> countries = new ArrayList<String>();
		countries.add("India");
		countries.add("USA");
		
		for(int i=1; i<countries.size(); i++) {
			countries.add(i, "+");
		}
		System.out.println(countries);
	}
}
