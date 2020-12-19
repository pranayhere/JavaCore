package com.pranay.interview.arrays;

public class CountOfMatches {
    public static void main(String[] args) {
        CountOfMatches cm = new CountOfMatches();
        int count = cm.numberOfMatches(7);
        System.out.println("Count : " + count);
    }

    int maxMatches = 0;

    public int numberOfMatches(int teams) {
        if (teams == 0 || teams == 1)
            return 0;

        if (teams % 2 == 0) {
            maxMatches += teams / 2;
            numberOfMatches(teams / 2);
        } else {
            maxMatches += (teams - 1) / 2;
            numberOfMatches(((teams - 1) / 2) + 1);
        }

        return maxMatches;
    }
}


