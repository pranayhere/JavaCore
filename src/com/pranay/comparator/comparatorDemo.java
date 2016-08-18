package com.pranay.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class comparatorDemo {
	public static void main(String args[]) {
		List<Emp> empList = new ArrayList<Emp>();
		empList.add(new Emp("pranay",23,70000,2));
		empList.add(new Emp("ruju",1,1000,1));
		empList.add(new Emp("rahul",29,75000,1));
		
		System.out.println(empList);
		
		Collections.sort(empList, Emp.ageNameComparator);
		System.out.println(empList);
		
		Collections.sort(empList, Emp.ageComparator);
		System.out.println(empList);
		
		Collections.sort(empList, Emp.nameComparator);
		System.out.println(empList);
		
		Collections.sort(empList, Emp.salaryComparator);
		System.out.println(empList);
	}
}
