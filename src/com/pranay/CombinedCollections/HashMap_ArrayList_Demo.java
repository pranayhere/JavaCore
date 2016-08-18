package com.pranay.CombinedCollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

public class HashMap_ArrayList_Demo {
	Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
	
	public static void main(String[] args) {
		HashMap_ArrayList_Demo test = new HashMap_ArrayList_Demo();
		test.inputData("mango",5);
		test.inputData("apple",2);
		test.inputData("banana",3);
		test.inputData("kiwi", 7);
		test.inputData("orange",6);
		test.displayData();
		test.addData();
		System.out.println("-----------------");
		test.displayData();
	}

	private void addData() {
		ArrayList<Integer> list = map.get("mango");
		list.add(500);
	}

	private void displayData() {
		for(Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			System.out.print(entry.getKey()+" | ");
			for(int fruitNo : entry.getValue()) {
				System.out.print(fruitNo+" ");
			}
			System.out.println();
		}
	}

	private void inputData(String key, int n) {
		Random rndData = new Random();
		ArrayList<Integer> fruits = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			fruits.add(rndData.nextInt(10));
		}
		map.put(key, fruits);
	}
}
