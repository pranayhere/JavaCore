package com.pranay.comparator;

import java.util.Comparator;

public class Emp {
	private String name;
	private int age;
	private int salary;
	private int id;
	
	public Emp(String name, int age, int salary, int id) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Emp [name=" + name + ", age=" + age + ", salary=" + salary
				+ ", id=" + id + "]";
	}

	public static Comparator<Emp> salaryComparator = new Comparator<Emp>() {
		@Override
		public int compare(Emp e1, Emp e2) {
			// TODO Auto-generated method stub
			return e1.getSalary() - e2.getSalary();
		}
	};
	
	public static Comparator<Emp> ageComparator = new Comparator<Emp>() {

		@Override
		public int compare(Emp e1, Emp e2) {
			// TODO Auto-generated method stub
			return e1.getAge() - e2.getAge();
		}
	};
	
	public static Comparator<Emp> nameComparator = new Comparator<Emp>() {

		@Override
		public int compare(Emp e1, Emp e2) {
			// TODO Auto-generated method stub
			return e1.getName().compareTo(e2.getName());
		}
	};
	
	public static Comparator<Emp> ageNameComparator =  new Comparator<Emp>() {
		public int compare(Emp e1, Emp e2) {
			int result = e1.getId() - e2.getId();
			if(result == 0) 
				return e1.getName().compareTo(e2.getName());
			return result;
		}
	};
}

