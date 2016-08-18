package com.pranay.MCQ;

import java.util.ArrayList;
import java.util.Iterator;

public class INex7 {
	public static void main(String[] args) {
		ArrayList aList = new ArrayList();
		aList.add(new String("A"));
		aList.add(new String("B"));
		aList.add(new String("C"));
		aList.add(new String("D"));
		
		int i = 0;
		for(Iterator it = aList.iterator(); it.hasNext();) {
			System.out.println(aList.get(i++)+ " ");
		}
	}
}
