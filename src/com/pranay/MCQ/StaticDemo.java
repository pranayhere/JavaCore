package com.pranay.MCQ;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

interface abc {
	static void a() {
		System.out.println("Aaa");
	}
	int b();
}

public class StaticDemo implements abc {
	public static void main(String args[]) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		Set<Integer> hs = new HashSet<Integer>();
		
		Student s1 = new Student();
		s1.showData();
		Student s2 = new Student();
		s2.showData();
		Student.b++;
		s1.showData();
		abc.a();
	}

	@Override
	public int b() {
		// TODO Auto-generated method stub
		return 0;
	}
}

class Student {
	int a; // initialized to zero
	static int b; // initialized to zero only when class is loaded not for each
					// object created.

	Student() {
		// Constructor incrementing static variable b
		a++;
		b++;
	}

	public void showData() {
		System.out.println("Value of a = " + a);
		System.out.println("Value of b = " + b);
	}

	public static void increment() {
		b++;
	}

}