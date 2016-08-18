package com.pranay.hashset;

import java.util.HashSet;

public class hashsetDuplicates {
	public static void main(String args[]) {
		HashSet<Price> lhs = new HashSet<Price>();
        lhs.add(new Price("Banana", 20));
        lhs.add(new Price("Apple", 40));
        lhs.add(new Price("Orange", 20));
        lhs.add(new Price("Apple", 40));
       
        System.out.println(lhs);
        Price key = new Price();
        key.setCost(20);
        key.setName("Banana");
        
        System.out.println(lhs.contains(key));
	}
}
