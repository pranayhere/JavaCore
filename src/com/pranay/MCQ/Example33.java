package com.pranay.MCQ;

import java.util.HashSet;

class Animal{
    public String breed = "A";
    public void makesound(String arg){ 
    	System.out.println("dog");
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((breed == null) ? 0 : breed.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (breed == null) {
			if (other.breed != null)
				return false;
		} else if (!breed.equals(other.breed))
			return false;
		return true;
	}
    
 }
   
class Dog extends Animal {
    public String breed = "B";
	void makesound(Object arg){   // Is usage of object here permitted or not?
        System.out.println("bow");
    }
}

public class Example33 {
	public static void main(String[] args) {
		Animal a = new Dog();
		((Dog)a).makesound( new Integer(1));
		a.makesound("hello");

		Dog d = new Dog();
		System.out.println(d.breed);
		
		Dog d1 = new Dog();
		System.out.println(d1.breed);
		
		HashSet<Dog> s = new HashSet<Dog>();
		s.add(d);
		s.add(d1);
		System.out.println(s);
	}
}



class Plant {
	private String name;
	public Plant() {this("Fern");}
	public Plant(String name) { this.name = name; }
	public String getName() { return name; }
}
class Tree extends Plant {
	public void growFruit() { }
	public void dropLeaves() { }
}

class Super {
	private int a;

	protected Super(int a) {
		this.a = a;
	}
}

class Sub extends Super {
	public Sub(int a) {
		super(a);
	}

	public Sub() {
		super(5);
//		this.a = 5;
	}
}
