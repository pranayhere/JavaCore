package com.pranay.interview.arrays;

public class BulbSwitcher {
    public static void main(String[] args) {
        String target = "10111";
        int flips = minFlips(target);
        System.out.println("Flips : " + flips);
    }

    private static int minFlips(String target) {
        char init = '0';
        int flips = 0;
        for (char ch: target.toCharArray()) {
            if (init != ch) {
                flips++;
                if (init == '0')
                    init = '1';
                else
                    init = '0';
            }
        }
        return flips;
    }
}
