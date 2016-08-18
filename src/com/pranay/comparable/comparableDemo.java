package com.pranay.comparable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class comparableDemo {
	public static void main(String[] args) {
		List<Emp> empList = new ArrayList<Emp>();
		empList.add(new Emp("pranay", 1));
		empList.add(new Emp("ruju", 3));
		empList.add(new Emp("rahul", 3));
		
		System.out.println(empList);
		Collections.sort(empList);
		System.out.println(empList);
		
	}
}
