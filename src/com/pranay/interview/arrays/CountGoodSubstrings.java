package com.pranay.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class CountGoodSubstrings {
    public static void main(String[] args) {
        String s = "xyz";
        int ans = countGoodSubstrings(s);
        System.out.println("Ans : " + ans);
    }

    public static int countGoodSubstrings(String s) {
        Map<Character, Integer> hm = new HashMap<>();
        hm.put(s.charAt(0), 1);
        hm.put(s.charAt(1), hm.getOrDefault(s.charAt(1), 0) + 1);

        int lo = 0;
        int ans = 0;
        int hi = 2;
        while (hi < s.length()) {
            System.out.println(hm);
            char ch = s.charAt(hi++);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);

            if (hm.size() == 3)
                ans++;

            char rm = s.charAt(lo++);
            int cnt = hm.get(rm);
            if (cnt == 1)
                hm.remove(rm);
            else
                hm.put(rm, cnt - 1);
        }

        return ans;
    }
}
