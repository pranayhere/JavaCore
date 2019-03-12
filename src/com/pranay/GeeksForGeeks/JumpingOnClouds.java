package com.pranay.GeeksForGeeks;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JumpingOnClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] arr) {
    	int i=0;
		int count = 0;
		
    	while(i < arr.length - 1) {
    		if (i+2 >= arr.length || arr[i+2] == 1) {
    			i++;
    			count++;
       		} else {
    			i = i + 2;
    			count++;
    		}
    	}
    	return count;
    }

    public static void main(String[] args) throws IOException {
    	int c[] = {0, 0, 0, 1, 0, 0};
        int result = jumpingOnClouds(c);
        System.out.println(result);
    }
}
