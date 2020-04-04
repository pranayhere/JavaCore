package com.pranay.interview.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
	public String name;
	public double gradePointAverage;

	public Student(String name, double gradePointAverage) {
		this.name = name;
		this.gradePointAverage = gradePointAverage;
	}
}

public class SearchStudent {
	private static final Comparator<Student> compGPA = new Comparator<Student>() {
		@Override
		public int compare(Student a, Student b) {
			if (a.gradePointAverage != b.gradePointAverage) {
				return Double.compare(a.gradePointAverage, b.gradePointAverage);
			}
			return a.name.compareTo(b.name);
		}
	};

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();
		students.add(new Student("a", 1));
		students.add(new Student("b", 2));
		students.add(new Student("c", 3));
		students.add(new Student("d", 4));
		students.add(new Student("e", 5));

		Student target = new Student("d", 4);

		System.out.println(Collections.binarySearch(students, target, compGPA));
	}
}
