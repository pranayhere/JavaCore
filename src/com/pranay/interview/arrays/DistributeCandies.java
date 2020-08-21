package com.pranay.interview.arrays;

import java.util.Arrays;

public class DistributeCandies {
    public static void main(String[] args) {
        int candies = 100, num_people = 3;
        int[] ans = distributeCandies(candies, num_people);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        for (int give = 0; candies > 0; candies -= give) {
            people[give % num_people] +=  Math.min(candies, ++give);
        }
        return people;
    }
}
