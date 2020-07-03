package com.pranay.interview.misc;

// https://www.youtube.com/watch?v=7RLSjgBiNOo&t=452s

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Master {
    String secret;

    public int guess(String w) {
        int cnt = 0;
        for (int i = 0; i < secret.length() && i < w.length(); i++) {
            if (secret.charAt(i) == w.charAt(i)) {
                cnt++;
            }
        }
        if (cnt == secret.length())
            System.out.println("Word found");
        return cnt;
    }
}

public class GuessTheWord {
    public static void main(String[] args) {
        String secret = "acckzz";
        String[] wordlist = {"acckzz","ccbazz","eiowzz","abcczz"};
        Master master = new Master();
        master.secret = secret;
        GuessTheWord gw = new GuessTheWord();
        gw.findSecretWord(wordlist, master);
    }

    public void findSecretWord(String[] wordlist, Master master) {
        List<String> list = Arrays.asList(wordlist);

        for(int i = 0; i < 10; i++) {
            Map<String, Integer> zeroWord = new HashMap<>();
            for (String cand: list)
                for (String comp : list)
                    if (match(cand, comp) == 0)
                        zeroWord.put(comp, zeroWord.getOrDefault(comp, 0) + 1);

            int min = Integer.MAX_VALUE;
            String wrd = list.get(0);
            for (String w: zeroWord.keySet()) {
                int cnt = zeroWord.get(w);
                if (cnt < min) {
                    min = cnt;
                    wrd = w;
                }
            }
            // System.out.println(list);
            // System.out.println("Guess word : " + wrd);
            int guess = master.guess(wrd);
            if (guess == 6)
                break;

            List<String> tmp = new ArrayList<>();
            for (String w : list) {
                int cnt = match(w, wrd);
                if (cnt == guess)
                    tmp.add(w);
            }

            list = tmp;
        }
    }

    public int match(String cand, String comp) {
        int count = 0;
        for (int i = 0; i<cand.length() && i < comp.length(); i++) {
            if (cand.charAt(i) == comp.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
