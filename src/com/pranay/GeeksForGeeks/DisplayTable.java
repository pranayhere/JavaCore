package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DisplayTable {
	public static void main(String[] args) {
		List<List<String>> orders = new ArrayList<>();
		orders.add(Arrays.asList("David","3","Ceviche"));
		orders.add(Arrays.asList("Corina","10","Beef Burrito"));
		orders.add(Arrays.asList("David","3","Fried Chicken"));
		orders.add(Arrays.asList("Carla","5","Water"));
		orders.add(Arrays.asList("Carla","5","Ceviche"));
		orders.add(Arrays.asList("Rous","3","Ceviche"));
		List<List<String>> ans = displayTable(orders);
		System.out.println(ans);
	}

	private static List<List<String>> displayTable(List<List<String>> orders) {
		List<Integer> tableList = new ArrayList<>();
		Set<String> dishSet = new HashSet<>();
		HashMap<Integer, HashMap<String, Integer>> table = new HashMap<>();

		for (List<String> order: orders) {
			int tableNo = Integer.parseInt(order.get(1));
			String dish = order.get(2);
			dishSet.add(dish);

			if (table.containsKey(tableNo)) {
				HashMap<String, Integer> orderMap = table.get(tableNo);
				orderMap.put(dish, orderMap.getOrDefault(dish, 0) + 1);
			} else {
				HashMap<String, Integer> orderMap = new HashMap<>();
				orderMap.put(dish, 1);
				table.put(tableNo, orderMap);
				tableList.add(tableNo);
			}
		}
		table.forEach((k, v) -> System.out.println(k+ " -> " +v));
		Collections.sort(tableList);
		List<String> dishList = new ArrayList<>(dishSet);
		Collections.sort(dishList);
		dishList.add(0, "Table");

		System.out.println(tableList);
		System.out.println(dishList);
		List<List<String>> ans = new ArrayList<>();
		ans.add(dishList);
		for (int i = 0; i<tableList.size(); i++) {
			List<String> row = new ArrayList<>();
			int tableNo = tableList.get(i);
			row.add(""+tableNo);
			HashMap<String, Integer> orderMap = table.get(tableNo);
			for (int j = 1; j<dishList.size(); j++) {
				String dish = dishList.get(j);
				if (orderMap.containsKey(dish)) {
					row.add(orderMap.get(dish).toString());
				} else {
					row.add("0");
				}
			}
			ans.add(row);
		}
		return ans;
	}
}
