package com.pranay.interview.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words
 * exactly once and without any intervening characters.
 * Example 1:
 *
 * Input:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 *
 * Input:
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * Output: []
 */

public class SubstringWithConcatOfAllWords {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";

        String[] words = {"word","good","best","good"};
        //String s = "barfoothefoobarman";
        //String[] words = {"foo","bar"};
        List<Integer> ans = findSubstring(s, words);
        System.out.println("Ans : " + ans);
    }

    private static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        if (s.length() == 0 || words.length == 0) {
            return res;
        }

        int len = words[0].length();

        Map<String, Integer> hm = new HashMap<>();
        for (String word: words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i<=s.length() - len * words.length; i++) {
            Map<String, Integer> copy = new HashMap<>(hm);
            for (int j = 0; j < words.length; j++) {
                String str = s.substring(i + j * len, i + j * len + len);
                if (copy.containsKey(str)) {
                    int count = copy.get(str);
                    if (count == 1)
                        copy.remove(str);
                    else
                        copy.put(str, count - 1);

                    if (copy.isEmpty()) {
                        res.add(i);
                        break;
                    }
                } else
                    break;
            }
        }
        return res;
    }
}
