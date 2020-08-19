package com.pranay.interview.greedy;

import java.util.HashMap;
import java.util.Map;

public class ConvertStringInKMoves {
    public static void main(String[] args) {
        String s = "input", t = "ouput";
        int k = 9;

        boolean ans = canConvertString(s, t, k);
        System.out.println("Ans : " + ans);
    }

    private static boolean canConvertString(String s, String t, int k) {
        Map<Integer, Integer> hm = new HashMap<>();

        if (s.length() != t.length())
            return false;

        for (int i = 0; i < s.length(); i++) {
            int dist = ((t.charAt(i) - s.charAt(i)) + 26) % 26;
            if (dist > 0)
                hm.put(dist, hm.getOrDefault(dist, 0) + 1);
        }

        for (int dist: hm.keySet()) {
            int count = hm.get(dist);
            if ((count - 1) * 26 + dist > k)
                return false;
        }

        return true;
    }

//
//    private static boolean canConvertString(String s, String t, int k) {
//        Map<Integer, Integer> hm = new HashMap<>();
//
//        if (s.length() != t.length())
//            return false;
//
//        for (int i = 0; i < s.length(); i++) {
//            int dist = ((t.charAt(i) - s.charAt(i)) + 26) % 26;
//            int prevDist = hm.getOrDefault(dist, 0);
//            if (dist > 0)
//                hm.put(dist, prevDist + 1);
//
//            if (prevDist * 26 + dist > k)
//                return false;
//        }
//
//        return true;
//    }


}
