package com.pranay.MCQ;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example32 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		list.add("test3");
		
		Iterator<String> iterator = list.iterator();
		iterator.remove();	//	IllegalStateException
		
		System.out.println(list);
	}
}
