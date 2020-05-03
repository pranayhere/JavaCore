package com.pranay.Leetcode31DaysOfMay;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        boolean ans = canConstruct(ransomNote, magazine);
        System.out.println("can construct : " + ans);
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        System.out.println(hm);

        for (char ch : ransomNote.toCharArray()) {
            if (hm.containsKey(ch)) {
                int count = hm.get(ch);
                count--;
                if (count == 0) {
                    hm.remove(ch);
                } else {
                    hm.put(ch, count);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
