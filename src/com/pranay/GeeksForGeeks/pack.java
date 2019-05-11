package com.pranay.GeeksForGeeks;

public class pack {
	public static void main(String[] args) {
		int m = 6;
		int n = 4;

		String matrixStr = "1,1,1,0,1,1,1,1,0,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1";
		String[] matrix = matrixStr.split(",");

		int[][] arr = new int[m][n];

        for(int i=0; i<m; i++) 
            for(int j=0; j<n; j++) 
                arr[i][j] = Integer.valueOf(matrix[(i*n) + j]);

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
	}
}