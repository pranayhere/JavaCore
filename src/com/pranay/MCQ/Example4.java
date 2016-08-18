package com.pranay.MCQ;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class Example4 {
	public static void main(String[] args) {
		Map<String, Object> map = new TreeMap<String, Object>();
		System.out.println(map instanceof Object);
		System.out.println(map instanceof Map);
		System.out.println(map instanceof TreeMap);
		System.out.println(map instanceof Collection);
		
	}
}
