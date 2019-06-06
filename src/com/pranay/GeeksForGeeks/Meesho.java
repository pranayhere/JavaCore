package com.pranay.GeeksForGeeks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Meesho {
    public static void main(String[] args) {
    	int[] A = {1,1,1,1,1};
    	int N = 5;
    	int queries[] = {1,2};
    	int Q = 2;
    	int[] ans = solve(A, N, queries, Q);
    	for (int i: ans) {
    		System.out.println(i);
    	}
    }
    static int[] solve(int[] A,int N, int[] queries,int Q){
        int[] ans = new int[Q];
        int max = Integer.MIN_VALUE;
        for (int i=0; i<N; i++) {
            max = Math.max(max, A[i]);
        }
        System.out.println("Max : "+max);
        ArrayList<Integer>[] arr = (ArrayList<Integer> []) new ArrayList[max+1];
        for (int i = 1; i<=max; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        
        for (int i=0; i<N; i++) {
            arr[A[i]].add(i);
        }
        
        for(ArrayList<Integer> list : arr) {
        	System.out.println(list);
        }
        
        for (int i=1; i<=Q; i++) {
        	if (queries[i] > max) {
        		ans[i-1] = -1;
        		continue;
        	}
            ArrayList<Integer> list = arr[i];
            if (list.size() > 1) {
                int b = list.get(list.size() - 1);
                int a = list.get(list.size() - 2);
                int diff = b - a;
                ans[i-1] = diff;
            } else {
                ans[i-1] = -1;
            }
        }
        return ans;
    }
}
