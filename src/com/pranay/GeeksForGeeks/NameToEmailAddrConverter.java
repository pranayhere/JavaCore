package com.pranay.GeeksForGeeks;

//you can also use imports, for example:
import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

public class NameToEmailAddrConverter {
 public String solution(String S, String C) {
     return emailAddress(S, C);
 }
 
 public static String emailAddress(String s, String c) {
     String[] names = s.split(";");
     String ans = "";
     Map<String, Integer> hm = new HashMap<>();
     
     for(String name : names) {
         String[] fullname = name.trim().split(" ");
         
         String first = "";
         String middle = "";
         String last = "";
         
         if (fullname.length == 3) {
             first = fullname[0].toLowerCase();
             middle = fullname[1].toLowerCase();
             last = fullname[2].toLowerCase();
             last = last.replaceAll("\\-", "");
         } else {
             first = fullname[0].toLowerCase();
             last = fullname[1].toLowerCase();
             last = last.replaceAll("\\-", "");
         }

         String email_name = last+ "_" +first;
         int count = 1;
         if (hm.containsKey(email_name)) {
             count = hm.get(email_name);
             count++;
             hm.put(email_name, count);
         } else {
             hm.put(email_name, count);
         }
         if (count > 1) {
             email_name += Integer.toString(count);
         }
         email_name += "@"+c.toLowerCase()+".com; ";
         ans += email_name;
     }
     return ans.substring(0, ans.length() - 2);
 }
}