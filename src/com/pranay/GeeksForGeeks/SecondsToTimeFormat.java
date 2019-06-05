package com.pranay.GeeksForGeeks;

public class SecondsToTimeFormat {
 public String solution(int T) {
     return convert(T);
 }
 
 static String convert(int seconds) {
     seconds = seconds % (24 * 3600);
     int hour = seconds / 3600;
     seconds %= 3600;
     int minutes = seconds / 60;
     seconds %= 60;
     
     // System.out.println(hour +"h"+minutes+"m"+seconds+"s");
     return hour+"h"+minutes+"m"+seconds+"s";
 }
}