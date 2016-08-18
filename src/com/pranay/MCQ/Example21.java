package com.pranay.MCQ;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Example21 {
	public static void main(String[] args) {
		List<Object> lst = new LinkedList<Object>();
		appendAndPrint(lst,"hello");
	}

	private static <T> void appendAndPrint(Collection<T> ds,  T t) {
		// TODO Auto-generated method stub
		ds.add(t);
		System.out.println(ds);
	}
}