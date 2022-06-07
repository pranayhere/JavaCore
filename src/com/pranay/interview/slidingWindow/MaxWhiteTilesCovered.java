package com.pranay.interview.slidingWindow;

import java.util.Arrays;

/**
 * 2271. Maximum White Tiles Covered by a Carpet
 * https://leetcode.com/problems/maximum-white-tiles-covered-by-a-carpet
 */
public class MaxWhiteTilesCovered {
    public static void main(String[] args) {
        int[][] tiles = {{1,5},{10,11},{12,18},{20,25},{30,32}};
        int carpetLen = 10;

        int ans = maximumWhiteTiles(tiles, carpetLen);
        System.out.println("Ans : " + ans);
    }

    private static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a, b) -> a[0] - b[0]);
        int max = 0;
        int cnt = 0;
        int l = 0;

        for (int r = 0; r < tiles.length; r++) {
            cnt += tiles[r][1] - tiles[r][0] + 1;
            int len = 0;

            while (l < tiles.length && (len = tiles[r][1] - tiles[r][0] + 1) > carpetLen) {
                max = Math.max(max, cnt - len + carpetLen);
                cnt -= tiles[l][1] - tiles[l][0] + 1;
                l++;
            }

            max = Math.max(max, cnt);
            if (max == carpetLen)
                return max;
        }
        return max;
    }
}
