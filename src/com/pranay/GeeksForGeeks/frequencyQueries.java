package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class frequencyQueries {
	public static void main(String[] args) {
		List<List<Integer>> queries = new ArrayList<>();
		int[][] ops = {
				{1,3},
				{2,3},
				{3,2},
				{1,4},
				{1,5},
				{1,5},
				{1,4},
				{3,2},
				{2,4},
				{3,2}
		};

		for (int i=0; i<10; i++) {
			List<Integer> row = new ArrayList<>();
			row.add(ops[i][0]);
			row.add(ops[i][1]);
			queries.add(row);
		}
		
		List<Integer> ans = freqQuery(queries);
		System.out.println(ans);
	}

	static Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
	
	private static List<Integer> freqQuery(List<List<Integer>> queries) {
		List<Integer> ans = new ArrayList<Integer>();
		for (List<Integer> i: queries) {
			switch(i.get(0)) {
				case 1 :
					addToMap(i.get(1));
					continue;
				case 2 :
					removeFromMap(i.get(1));
					continue;
				case 3 :
					if (hm.containsValue(i.get(1))) {
						ans.add(1);
					} else {
						ans.add(0);
					}
					continue;
			}
		}
		return ans;
	}

	private static void removeFromMap(Integer key) {
		if (hm.containsKey(key)) {
			int count = hm.get(key);
			count--;
			if (count == 0) {
				hm.remove(key);
				return;
			}

			hm.put(key, count);
		}
	}

	private static void addToMap(Integer key) {
		int count = 1;
		if (hm.containsKey(key)) {
			count = hm.get(key);
			hm.put(key, ++count);
			return;
		}
		hm.put(key, count);
	}
	
//	Java 8
//	static List<Integer> freqQuery(List<List<Integer>> queries) {
//        List<Integer> result = new ArrayList<>();
//        List<Integer> data = new ArrayList<>();
//        HashMap<Integer, Function<Integer, Boolean>> mapa = new HashMap<>();
//        mapa.put(1, o -> data.add(o));
//        mapa.put(2, o -> data.remove(o));
//        mapa.put(3, o -> {
//            Map<Integer, Long> counts = data.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
//            return result.add(counts.containsValue(new Long(o))? 1:0);
//        });
//        queries.forEach(integers -> {
//            mapa.get(integers.get(0)).apply(integers.get(1));
//        });
//        return  result;
//    }
}