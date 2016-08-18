package com.pranay.ListIteratorDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		
		ListIterator<String> itr = list.listIterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		while(itr.hasPrevious()) {
			System.out.print(itr.previous());
		}
	}
}
