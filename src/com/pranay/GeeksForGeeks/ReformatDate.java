package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReformatDate {
    public static void main(String[] args) {
        String date = "22nd Apr 2023";
        String formattedDate = reformatDate(date);
        System.out.println("Ans  : " + formattedDate);
    }

    private static String reformatDate(String date) {
        String[] arr = date.split(" ");
        Map<String, String> mm = new HashMap<>();
        mm.put("Jan", "01");
        mm.put("Feb", "02");
        mm.put("Mar", "03");
        mm.put("Apr", "04");
        mm.put("May", "05");
        mm.put("Jun", "06");
        mm.put("Jul", "07");
        mm.put("Aug", "08");
        mm.put("Sep", "09");
        mm.put("Oct", "10");
        mm.put("Nov", "11");
        mm.put("Dec", "12");

        List<String> abbr = List.of("th", "st", "rd", "nd");

        for (String str : abbr) {
            if (arr[0].indexOf(str) > 0) {
                arr[0] = arr[0].substring(0, arr[0].indexOf(str));
            }
        }

        if (Integer.parseInt(arr[0]) < 10) {
            arr[0] = "0" + arr[0];
        }
        return arr[2] +"-"+ mm.get(arr[1]) + "-" + arr[0];
    }
}
