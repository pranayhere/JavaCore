package com.pranay.interview.heap;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class MaximumNumberOfEatenApples {
    public static void main(String[] args) {
        int[] apples = {1, 2, 3, 5, 2};
        int[] days = {3, 2, 1, 4, 2};
//        int[] apples = {3,0,0,0,0,2};
//        int[] days = {3,0,0,0,0,2};

//        Input:
//        int[] apples = {9, 10, 1, 7, 0, 2, 1, 4, 1, 7, 0, 11, 0, 11, 0, 0, 9, 11, 11, 2, 0, 5, 5};
//        int[] days = {3, 19, 1, 14, 0, 4, 1, 8, 2, 7, 0, 13, 0, 13, 0, 0, 2, 2, 13, 1, 0, 3, 7};
//        Output:
//        29
//        Expected:
//        31

        int ans = eatenApples(apples, days);
        System.out.println("Ans : " + ans);
    }

    public static int eatenApples(int[] apples, int[] days) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int count = 0;
        for (int currentDay = 0; currentDay < apples.length || map.higherKey(currentDay) != null; currentDay++) {
            // calculate the expiry of apples received on currentDay and update map
            if (currentDay < apples.length) {
                int currentExpiry = currentDay + days[currentDay];
                map.put(currentExpiry, map.getOrDefault(currentExpiry, 0) + apples[currentDay]);
            }
            // eat an apple on current day
            Integer latestExpiryDay = map.higherKey(currentDay);
            if (latestExpiryDay != null) {
                count++;
                if (map.get(latestExpiryDay) > 1)
                    map.put(latestExpiryDay, map.get(latestExpiryDay) - 1);
                else
                    map.remove(latestExpiryDay);
            }
        }
        return count;
    }


    private static int eatenApplesMine(int[] apples, int[] days) {
        int res = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int length = apples.length;
        for (int day = 0; day < 40001; day++) {
            if (day < length) {
                pq.add(new int[]{day + days[day] - 1, apples[day]});
            }

            while (!pq.isEmpty()) {
                int[] cur = pq.peek();
                if (cur[0] < day) {
                    pq.poll();
                } else {
                    break;
                }
            }

            if (!pq.isEmpty()) {
                int[] cur = pq.poll();
                cur[1]--;
                res += 1;
                if (cur[1] > 0) {
                    pq.add(cur);
                }
            }
        }
        return res;
    }
}
