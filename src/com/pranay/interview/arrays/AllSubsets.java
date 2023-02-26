package com.pranay.interview.arrays;

public class AllSubsets {
    public static void main(String[] args) {
        String s = "abc";
        AllSubsets as = new AllSubsets();
        as.allSubsets(s);
    }

    public void allSubsets(String s) {
        subsets(s, "");
    }

    public void subsets(String ip, String op) {
        if (ip.length() == 0) {
            System.out.println(op);
            return;
        }

        subsets(ip.substring(1), op);
        subsets(ip.substring(1), op += ip.charAt(0));
    }
}
