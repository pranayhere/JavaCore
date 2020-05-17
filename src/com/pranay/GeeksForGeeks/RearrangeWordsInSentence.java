package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RearrangeWordsInSentence {
    public static void main(String[] args) {
        String text = "Keep calm and code on";
        String output = arrangeWords(text);
        System.out.println("Ans : " + output);
    }

    private static String arrangeWords(String text) {
        Map<Integer, List<String>> map = new TreeMap<>();
        for (String str : text.split(" ")) {
            int len = str.length();
            if (map.containsKey(len)) {
                List<String> list = map.get(len);
                list.add(str.toLowerCase());
                map.put(len, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str.toLowerCase());
                map.put(len, list);
            }
        }
        StringBuilder ans = new StringBuilder();

        for (List<String> list: map.values()) {
            for (String str: list) {
                ans.append(" ").append(str);
            }
        }
        String ret = ans.toString().trim();
        return ret.substring(0, 1).toUpperCase() + ret.substring(1);
    }
}
