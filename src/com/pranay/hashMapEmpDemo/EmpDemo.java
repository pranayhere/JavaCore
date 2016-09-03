package com.pranay.hashMapEmpDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

class Emp {
	private String name;

	public Emp(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	@Override
//	public String toString() {
//		return "Emp [name=" + name + "]";
//	}
}

public class EmpDemo {
	public static void main(String[] args) {
		HashMap<Emp, String> map = new HashMap<Emp, String>();
		Emp e1 = new Emp("Pranay");
		map.put(e1, "Mumbai");
		System.out.println(map);
		e1.setName("rahul");
		System.out.println(map);

//		for (Emp key : map.keySet()) {
//			System.out.println("Iterating or looping map using java5 foreach loop");
//			System.out.println("key: " + key.getName() + " value: " + map.get(key));
//		}
	
//		Iterator<Entry<Emp,String>> entrySetIterator = map.entrySet().iterator();
//		while(entrySetIterator.hasNext()) {
//			Entry entry = entrySetIterator.next();
//			System.out.println("key: " + entry.getKey().toString() + " value: " + entry.getValue());
//		}
	
	}
}