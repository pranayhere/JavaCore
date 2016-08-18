package com.pranay.ConcurrentHashMapDemo;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcurrentHashMap<String, String> chm = new ConcurrentHashMap<String, String>();
		chm.put("pranay", "abc");
		chm.put("rahul", "jjd");
		chm.put("rujju", "sdad");
		
		Iterator<String> iterator = chm.keySet().iterator();
		while(iterator.hasNext()){
			System.out.println(chm.get(iterator.next()));
			chm.put("abbbbccc", "asdjsajhd");
		}
	}

}
