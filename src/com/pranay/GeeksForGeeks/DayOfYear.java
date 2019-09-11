package com.pranay.GeeksForGeeks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

// https://leetcode.com/problems/ordinal-number-of-date/

public class DayOfYear {
    public static void main(String[] args) {
        String date = "2019-01-21";
        String day = dayOfYear(date);
	    if (day.equals("SUNDAY"))
		    day = "Sunday";
	    if (day.equals("MONDAY"))
		    day = "Monday";
	    if (day.equals("TUESDAY"))
		    day = "Tuesday";
	    if (day.equals("WEDNESDAY"))
		    day = "Wednesday";
	    if (day.equals("THURSDAY"))
		    day = "Thursday";
	    if (day.equals("FRIDAY"))
		    day = "Friday";
	    if (day.equals("SATURDAY"))
		    day = "Saturday";

	    System.out.println(day);
    }

    private static String dayOfYear(String date) {

        return LocalDate.parse(date).getDayOfWeek().toString();
    }
}
