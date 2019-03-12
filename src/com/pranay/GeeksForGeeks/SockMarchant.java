package com.pranay.GeeksForGeeks;
/*
John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

For example, there are  socks with colors . There is one pair of color  and one of color . There are three odd socks left, one of each color. The number of pairs is .

Function Description

Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.

sockMerchant has the following parameter(s):

n: the number of socks in the pile
ar: the colors of each sock
Input Format

The first line contains an integer , the number of socks represented in . 
The second line contains  space-separated integers describing the colors  of the socks in the pile.

Input :
9
10 20 20 10 10 30 50 10 20

output :
3

Return the total number of matching pairs of socks that John can sell.

*/


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SockMarchant {
    static int sockMerchant(int n, int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i<n; i++) {
            Integer count = 1;
            if(hm.containsKey(arr[i])) {
                count = hm.get(arr[i]);
                count ++;
            }
            hm.put(arr[i], count);
        }

        int pairs = 0;
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
        	pairs += Math.abs(entry.getValue() / 2);
        }

        return pairs;
    }

    public static void main(String[] args) throws IOException {
        int n = 9;
        int[] ar = {10, 20, 20, 10, 10, 30, 50, 10, 20};
        int result = sockMerchant(n, ar);
        System.out.println("No of pairs : " + result);
    }
}
