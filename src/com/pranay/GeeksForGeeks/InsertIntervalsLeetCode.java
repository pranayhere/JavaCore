package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/insert-interval/

public class InsertIntervalsLeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intervals[][] = {{1,3},{6,9}};
		int newInterval[] = {4,5};
		
		int[][] ans = insertInterval(intervals, newInterval);
		for (int[] inte: ans) {
			System.out.println(Arrays.toString(inte));
		}
	}

	private static int[][] insertInterval(int[][] intervals, int[] newInterval) {
		if(intervals.length<=0) {
            int[][] res = new int[1][];
            res[0] = newInterval;
            return res;
        }
        if(newInterval.length<=0) return intervals;
        
        List<int[]> res = new ArrayList<int[]>();
        boolean addedInterval = false;
        for(int[] interval : intervals){
            if(newInterval[0] >= interval[0] && newInterval[0]<= interval[1]){
                //new interval start after interval, update newInterval start
                newInterval[0] = interval[0];
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else if(newInterval[1] >= interval[0] && newInterval[1]<= interval[1]) {
                //new interval before after interval, update newInterval end
                newInterval[1] = interval[1];
                newInterval[0] = Math.min(newInterval[0], interval[0]);
            } else if (newInterval[0] <= interval[0] && newInterval[1] >= interval[1]) {
                //new interval covers interval, do nothing
            } else {
                res.add(interval);
            } 
        }
        res.add(newInterval); 
        int[][] result = res.toArray(new int[res.size()][]);
        Arrays.sort(result, (i1, i2) -> Integer.compare(i1[0], i2[0]) );
        return result;
	}
}
