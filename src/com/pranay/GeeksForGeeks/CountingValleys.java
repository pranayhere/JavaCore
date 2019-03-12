package com.pranay.GeeksForGeeks;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
    	int seaLevel = 0;
    	int valleyCount = 0;
    	for(int i=0; i<s.length(); i++) {
    		if (s.charAt(i) == 'U') {
    			if (seaLevel == -1)
    				valleyCount++;
    			seaLevel++;
    		}
    		else
    			seaLevel--;
    		
//    		System.out.println(seaLevel);
//    		if (seaLevel == 0)
//    			valleyCount++;
    	}
    	
    	return valleyCount;
    }

    public static void main(String[] args) throws IOException {
    	int n = 8;
    	String s = "DDUUUUDD";
        int result = countingValleys(n, s);
        System.out.println(result);
    }
}
