package com.pranay.interview.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A string S represents a list of words.
 *
 * Each letter in the word has 1 or more options.  If there is one option, the letter is represented as is.
 * If there is more than one option, then curly braces delimit the options.  For example, "{a,b,c}" represents options ["a", "b", "c"].
 *
 * For example, "{a,b,c}d{e,f}" represents the list ["ade", "adf", "bde", "bdf", "cde", "cdf"].
 *
 * Return all words that can be formed in this manner, in lexicographical order.
 *
 * Example 1:
 *
 * Input: "{a,b}c{d,e}f"
 * Output: ["acdf","acef","bcdf","bcef"]
 *
 * Example 2:
 *
 * Input: "abcd"
 * Output: ["abcd"]
 */
public class BraceExpansion {
    public static void main(String[] args) {
        String S = "{a,b}c{d,e}f";
        String[] arr = expand(S);
        System.out.println("Ans : " + Arrays.toString(arr));
    }

    private static String[] expand(String S) {
        String[] array = S.split("\\{|\\}");
        List<String> res = new ArrayList<>();
        dfs(res, array, 0, "");
        return res.toArray(new String[res.size()]);
    }

    private static void dfs(List<String> res, String[] array, int curr, String word) {
        if (curr >= array.length) {
            res.add(word);
            return;
        }

        String[] possibles = array[curr].split(",");
        Arrays.sort(possibles);
        for (String s : possibles)
            dfs(res, array, curr + 1, word + s);
    }
}
