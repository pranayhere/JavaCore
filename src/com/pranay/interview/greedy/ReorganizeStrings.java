package com.pranay.interview.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 767. Reorganize String
 * https://leetcode.com/problems/reorganize-string/
 *
 * similar: task scheduler https://leetcode.com/problems/task-scheduler/
 */
public class ReorganizeStrings {
    public static void main(String[] args) {
        String s = "vvvlo";
        String ans = reorganizeString(s);
        System.out.println("Ans : " + ans);
    }

    private static String reorganizeString(String S) {
        // Create map of each char to its count
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            // Impossible to form a solution
            if (count > (S.length() + 1) / 2) return "";
            map.put(c, count);
        }
        // Greedy: fetch char of max count as next char in the result.
        // Use PriorityQueue to store pairs of (char, count) and sort by count DESC.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c : map.keySet()) {
            pq.add(new int[] {c, map.get(c)});
        }
        // Build the result.
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            } else {
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }

    private static String reorganizeString2(String S) {
        Map<Character, Integer> hm = new HashMap<>();
        int n = S.length();

        for (char ch: S.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            if (hm.get(ch) > (n - 1) / 2)
                return "";
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char ch: hm.keySet()) {
            pq.add(new int[]{ch, hm.get(ch)});
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();

            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != first[0]) {
                sb.append(first[0]);
                if (--first[1] > 0)
                    pq.offer(first);
            } else {
                int[] second = pq.poll();
                sb.append(second[0]);
                if (--second[1] > 0)
                    pq.offer(second);

                pq.offer(first);
            }
        }
        return sb.toString();
    }
}
