package com.pranay.MCQ;

import java.util.Iterator;
import java.util.TreeSet;

public class Example19 {
	public static void main(String[] args) {
		TreeSet s1 = new TreeSet();
		s1.add(new String("one"));
		s1.add(new String("two"));
		s1.add(new String("three"));
		s1.add(new String("one"));
		
		Iterator it = s1.iterator();
		while(it.hasNext()) {
			System.out.println(it.next()+" ");
		}
	}
}