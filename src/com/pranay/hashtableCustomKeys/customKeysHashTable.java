package com.pranay.hashtableCustomKeys;

import java.util.Hashtable;

public class customKeysHashTable {
	public static void main(String[] args) {
		Hashtable<Emp, String> ht = new Hashtable<Emp, String>();
		ht.put(new Emp("pranay", 1, 1000), "Bangalore");
		ht.put(new Emp("rahul", 2, 1111), "Mumbai");
		ht.put(new Emp("abdc", 1, 1112), "Hydrabad");
		
		System.out.println(ht);
	}
}
