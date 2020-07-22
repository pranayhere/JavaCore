package com.pranay.interview.misc;

// https://www.youtube.com/watch?v=7RLSjgBiNOo&t=452s

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 843. Guess the Word
 * https://leetcode.com/problems/guess-the-word/
 */
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
//        String secret = "acckzz";
//        String[] wordlist = {"acckzz","ccbazz","eiowzz","abcczz"};

        String secret = "ccoyyo";
        String[] wordlist = {"wichbx","oahwep","tpulot","eqznzs","vvmplb","eywinm","dqefpt","kmjmxr","ihkovg","trbzyb","xqulhc","bcsbfw","rwzslk","abpjhw","mpubps","viyzbc","kodlta","ckfzjh","phuepp","rokoro","nxcwmo","awvqlr","uooeon","hhfuzz","sajxgr","oxgaix","fnugyu","lkxwru","mhtrvb","xxonmg","tqxlbr","euxtzg","tjwvad","uslult","rtjosi","hsygda","vyuica","mbnagm","uinqur","pikenp","szgupv","qpxmsw","vunxdn","jahhfn","kmbeok","biywow","yvgwho","hwzodo","loffxk","xavzqd","vwzpfe","uairjw","itufkt","kaklud","jjinfa","kqbttl","zocgux","ucwjig","meesxb","uysfyc","kdfvtw","vizxrv","rpbdjh","wynohw","lhqxvx","kaadty","dxxwut","vjtskm","yrdswc","byzjxm","jeomdc","saevda","himevi","ydltnu","wrrpoc","khuopg","ooxarg","vcvfry","thaawc","bssybb","ccoyyo","ajcwbj","arwfnl","nafmtm","xoaumd","vbejda","kaefne","swcrkh","reeyhj","vmcwaf","chxitv","qkwjna","vklpkp","xfnayl","ktgmfn","xrmzzm","fgtuki","zcffuv","srxuus","pydgmq"};

        Master master = new Master();
        master.secret = secret;
        GuessTheWord gw = new GuessTheWord();
        gw.findSecretWord(wordlist, master);
    }

    public void findSecretWord(String[] wordlist, Master master) {
        Random ran = new Random();
        ArrayList<String> possibles = new ArrayList<>();
        for (String word: wordlist) {
            possibles.add(word);
        }

        for (int i = 0; i < 10; i++) { // Given, 10 trials allowed
            int index = ran.nextInt(possibles.size());
            String testWord = possibles.get(index);
            int matches = master.guess(testWord);
            if (matches == 6)
                return;

            ArrayList<String> newPossibles = new ArrayList<>();
            for (String w: possibles) {
                int matchCount = match(w, testWord);
                if (matchCount == matches)
                    newPossibles.add(w);
            }

            possibles = newPossibles;
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
