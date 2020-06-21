package com.pranay.interview.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifyAlienDictionary {
    public static void main(String[] args) {
        String[] words = {"fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"};
        String order = "zkgwaverfimqxbnctdplsjyohu";
//        String[] words = {"hello","leetcode"};
//        String order = "hlabcdefgijkmnopqrstuvwxyz";
        boolean res = isAlienSorted(words, order);
        System.out.println("Result : " + res);
    }

    private static boolean isAlienSorted(String[] words, String order) {
        char[] arr = order.toCharArray();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return false;
            }

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    int index1 = list.indexOf(word1.charAt(j));
                    int index2 = list.indexOf(word2.charAt(j));
                    if (index1 > index2)
                        return false;
                    break;
                }
            }
        }
        return true;
    }
}
