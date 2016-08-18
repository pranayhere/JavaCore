package com.pranay.MCQ;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Base {}
class childClass extends Base{}

public class Example26 {
	public static void main(String[] args) {
		List<Base> list1 = new ArrayList<Base>();
		list1.add(new Base());
		list1.add(new childClass());

		Iterator i = list1.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
