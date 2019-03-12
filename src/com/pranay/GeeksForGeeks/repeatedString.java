package com.pranay.GeeksForGeeks;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class repeatedString {
    static long repeatedString(String s, long n) {
    	long result = s.chars().filter(ch -> ch == 'a').count();
    	int numberOfRepetations = (int) (n / s.length());
    	int remainingFields = (int) (n % s.length());
    	s = s.substring(0, remainingFields);
    	long result2 = s.chars().filter(ch -> ch == 'a').count();
    	int finalResult = (int) (result * numberOfRepetations + result2);
    	return finalResult;
    }

    public static void main(String[] args) throws IOException {
    	String s = "aba";
    	long n = 10;
        long result = repeatedString(s, n);
        System.out.println(result);
    }
}
