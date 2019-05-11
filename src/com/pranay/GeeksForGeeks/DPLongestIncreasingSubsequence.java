package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DPLongestIncreasingSubsequence 
{ 
   static int max_ref; // stores the LIS 
  
   static int _lis(int arr[], int n) 
   { 
	
       if (n == 1) 
           return 1; 
  
       int res, max_ending_here = 1; 
  
        for (int i = 1; i < n; i++) 
        { 
            res = _lis(arr, i); 
            if (arr[i-1] < arr[n-1] && res + 1 > max_ending_here) 
                max_ending_here = res + 1; 
        } 
        if (max_ref < max_ending_here) 
           max_ref = max_ending_here; 
  
        return max_ending_here; 
   } 
  
    static int lis(int arr[], int n) 
    { 
         max_ref = 1; 
  
        _lis( arr, n); 
  
        return max_ref; 
    } 
  
    public static void main(String args[]) 
    { 
        int arr[] = { 2,1,3,1,6,2 }; 
        for (int i = 1; i<arr.length; i++) {
        	List<Integer> list = new ArrayList<>();
        	for (int j=0; j<i; j++) {
        		list.add(arr[j]);
        	}

        	int lis[] = new int[list.size()];
        	for (int k=0; k<list.size(); k++)
        		lis[k] = list.get(k);

        	System.out.println(lis(lis, list.size()));
        }
    } 
 } 