package com.pranay.GeeksForGeeks;

import java.time.LocalDate;

// https://leetcode.com/problems/ordinal-number-of-date/

public class DayOfYear {
    public static void main(String[] args) {
        String date = "2019-01-09";
        int day = dayOfYear(date);
        System.out.println(day);
    }

    private static int dayOfYear(String date) {
        return LocalDate.parse(date).lengthOfMonth();
    }
}
