package com.pranay.interview.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountHomogeneous {

    public static void main(String[] args) {
        String s = "abbcccaa";
        CountHomogeneous c = new CountHomogeneous();
        int ans = c.countHomogenous(s);
        System.out.println("Ans : " + ans);
    }

    private int countHomogenous(String s) {
        int cnt = 0, res = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (i > 0 && s.charAt(i - 1) == s.charAt(i))
                ++cnt;
            else
                cnt = 1;

            res = (res + cnt) % 1000000007;
        }

        return res;
    }
}

