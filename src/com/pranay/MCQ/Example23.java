package com.pranay.MCQ;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Example23 {
	public static void main(String[] args) {
		List a1 = new LinkedList();
		List a2 = new LinkedList();
		a1.add("one");
		a1.add("two");
		a2.add("two");
		a2.add("one");
		System.out.println(a1.equals(a2));	
	}
}
