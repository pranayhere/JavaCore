package com.pranay.interview.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestTimeForGivenDigits {
    public static void main(String[] args) {
        int[] A = {0,2,0,9};
        LargestTimeForGivenDigits ltd = new LargestTimeForGivenDigits();
        String time = ltd.largestTimeFromDigits(A);
        System.out.println("Time : " + time);
    }

    Map<Integer, Integer> hm = new HashMap<>();
    private String largestTimeFromDigits(int[] A) {
        for (int n: A)
            hm.put(n, hm.getOrDefault(n, 0) + 1);

        int hr;
        int min;
        boolean firstHr = false;
        boolean secHr = false;
        boolean firstMin = false;
        boolean secMin = false;

        for (hr = 23; hr >= 0; hr--) {
            firstHr = false;
            secHr = false;

            String h = hr > 9 ? hr + "" : "0" + hr;

            if (hm.containsKey(h.charAt(0) - '0')) {
                dec(h.charAt(0) - '0');
                firstHr = true;
            }


            if (hm.containsKey(h.charAt(1) - '0')) {
                dec(h.charAt(1) - '0');
                secHr = true;
            }

            if (firstHr && secHr)
                break;
            else if (firstHr)
                hm.put(h.charAt(0) - '0', hm.getOrDefault(h.charAt(0) - '0', 0) + 1);
            else if (secHr)
                hm.put(h.charAt(1) - '0', hm.getOrDefault(h.charAt(1) - '0', 0) + 1);
        }

        if (!firstHr || !secHr)
            return "";

        for (min = 59; min >= 0; min--) {
            firstMin = false;
            secMin = false;
            String m = min > 9 ? min + "" : "0" + min;


            if (hm.containsKey(m.charAt(0) - '0')) {
                dec(m.charAt(0) - '0');
                firstMin = true;
            }

            if (hm.containsKey(m.charAt(1) - '0')) {
                dec(m.charAt(1) - '0');
                secMin = true;
            }

            if (firstMin && secMin)
                break;
            else if (firstMin)
                hm.put(m.charAt(0) - '0', hm.getOrDefault(m.charAt(0) - '0', 0) + 1);
            else if (secMin)
                hm.put(m.charAt(1) - '0', hm.getOrDefault(m.charAt(1) - '0', 0) + 1);
        }

        if (!firstMin || !secMin)
            return "";

        String hour = hr < 10 ? "0" + hr : hr + "";
        String minutes = min < 10 ? "0" + min : min + "";

        return hour + ":" + minutes;
    }

    public void dec(int n) {
        int count = hm.get(n);
        if (count == 1)
            hm.remove(n);
        else
            hm.put(n, count - 1);
    }
}
