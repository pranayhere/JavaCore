package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PilesOfBoxes {

	public static void main(String[] args) {
		List<Integer> pilesOfBoxes = new ArrayList<Integer>();
		pilesOfBoxes.add(4);
		pilesOfBoxes.add(5);
		pilesOfBoxes.add(5);
		pilesOfBoxes.add(2);
		pilesOfBoxes.add(4);
		
		int steps = countSteps(pilesOfBoxes);
//		System.out.println("Total Steps : ");
		System.out.println(steps);
	}

	private static int countSteps(List<Integer> pilesOfBoxes) {
		int currentKey = 0;
		int prevKey = 0;
		int currentVal = 0;
		int prevVal = 0;
		int steps = 0;
		
		Map<Integer, Integer> tm = new TreeMap<Integer, Integer>(Collections.reverseOrder());
		
		for (Integer box : pilesOfBoxes) {
			int count = 1;
			if(tm.containsKey(box)) {
				count = tm.get(box);
				tm.put(box, count++);
			}
			tm.put(box, count);
		}
		
		for(Map.Entry<Integer, Integer> entry: tm.entrySet()) {
			
//			tm.forEach((k,v) -> System.out.println("Key = " + k + ", Value = " + v)); 
			
			prevKey = currentKey;
			currentKey = entry.getKey();

			if (prevKey == 0) {
				continue;
			}
			
			prevVal = tm.get(prevKey);
			currentVal = entry.getValue();
			
			int diff = 1;
			steps = steps + prevVal;
			int newVal = currentVal * prevVal;
			tm.put(currentKey, newVal);
		}
		return steps;
	}
}
