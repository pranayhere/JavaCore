package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class WordFromCharacters {
    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        int count = countCharacters(words, chars);
        System.out.println(count);
    }

    private static int countCharacters(String[] words, String chars) {
        int sum = 0;
        for(String word : words) {
            Map<String, Integer> map = new HashMap<>();
            for (String ch: chars.split("")) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }

            String[] ch = word.split("");
            for(int i = 0; i<ch.length; i++) {
                if (map.containsKey(ch[i])) {
                    int val = map.get(ch[i]);
                    if (val == 1) {
                        map.remove(ch[i]);
                    } else {
                        map.put(ch[i], --val);
                    }
                    if (i+1 == ch.length) {
                        System.out.println(word);
                        sum += ch.length;
                    }
                } else {
                    break;
                }
            }
        }
        return sum;
    }
}
