package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberOfPaths {

	public static void main(String[] args) {
		List<List<Integer>> a = new ArrayList<>();
		a.add(Arrays.asList(new Integer[] {1,1,1,1}));
		a.add(Arrays.asList(new Integer[] {1,1,1,1}));
		a.add(Arrays.asList(new Integer[] {1,1,1,1}));

		int count = numberOfPaths(a);
		System.out.println(count);
	}

	private static int numberOfPaths(List<List<Integer>> a) {
		int C = a.get(0).size();
		int R = a.size();
		int[][] maze = new int[R][C];
		
		for (int i = 0; i< a.size(); i++) {
			List<Integer> row = a.get(i);
			for (int j = 0; j<row.size(); j++) {
				int val = row.get(j);
				if (val == 1) 
					maze[i][j] = 0;
				else
					maze[i][j] = -1;
			}
		}
		
		for(int i = 0; i<R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
		
		int count = countPaths(maze, R, C);
		return count;
	}

	private static int countPaths(int[][] maze, int R, int C) {
		if (maze[0][0] == -1) {
			return 0;
		}
		
		for (int i = 0; i< R; i++) {
			if (maze[i][0] == 0) 
				maze[i][0] = 1;
			else
				break;
		}
		
		for (int i = 1; i < C; i++) {
			if (maze[0][i] == 0)
				maze[0][i] = 1;
			else
				break;
		}
		
		for (int i = 1; i< R; i++) {
			for (int j = 1; j<C; j++) {
				if(maze[i][j] == -1) 
					continue;
				
				if (maze[i-1][j] > 0)
					maze[i][j] = (maze[i][j] + maze[i-1][j]);
				
				if (maze[i][j-1] > 0)
					maze[i][j] = (maze[i][j] + maze[i][j-1]);
			}
		}
		
		return (maze[R-1][C-1] > 0) ? maze[R-1][C-1] : 0;
		
	}

}
