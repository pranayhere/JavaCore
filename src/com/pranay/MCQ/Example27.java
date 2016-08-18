package com.pranay.MCQ;

import java.util.ArrayList;
import java.util.List;

class Base1 {}
class Child1 extends Base {}

public class Example27 {
	public static void main(String[] args) {
		List<Base1> list1 = new ArrayList<Base1>();
		doWork(list1);
	}

	private static void doWork(List<Base1> list1) {
		// TODO Auto-generated method stub
		//list1.add(new Child1());
	}
}
