package com.pranay.interview.graph;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, newColor = 2;
        int[][] newImage = floodFill(image, sr, sc, newColor);
        for (int[] arr: newImage)
            System.out.println(Arrays.toString(arr));
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor)
            dfs(image, sr, sc, color, newColor);
        return image;
    }

    private static void dfs(int[][] image, int r, int c, int color, int newColor) {
        int nr = image.length;
        int nc = image[0].length;

        if (r < 0 || r >= nr || c < 0 || c >= nc || image[r][c] != color) {
            return;
        }

        image[r][c] = newColor;
        dfs(image, r - 1, c, color, newColor);
        dfs(image, r + 1, c, color, newColor);
        dfs(image, r, c - 1, color, newColor);
        dfs(image, r, c + 1, color, newColor);

    }
}
