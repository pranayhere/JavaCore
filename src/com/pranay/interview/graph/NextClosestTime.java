package com.pranay.interview.graph;

import java.time.Duration;
import java.util.Arrays;

public class NextClosestTime {
    public static void main(String[] args) {
        String time = "23:59";
        NextClosestTime nct = new NextClosestTime();
        String nextTime = nct.nextClosestTime(time);
        System.out.println("Next closest time : " +nextTime);
    }

    int diff = 0x3f3f3f3f;
    String result = "";
    int h;
    int m;

    private String nextClosestTime(String time) {
        int[] digits = new int[4];
        int tot = 0;
        String[] val = time.split(":");
        int hour = Integer.parseInt(val[0]);
        int min = Integer.parseInt(val[1]);

        digits[tot++] = hour / 10;
        digits[tot++] = hour % 10;
        digits[tot++] = min / 10;
        digits[tot++] = min % 10;

        h = hour;
        m = min;

        System.out.println("given : " + Arrays.toString(digits));
        dfs(digits, 0, new int[4]);
        return result;
    }


    void dfs(int[] digits, int i, int[] ans) {
        if (i == 4) {
            int hour = 10 * ans[0] + ans[1];
            int mins = 10 * ans[2] + ans[3];

            if (hour < 0 || hour >= 24 || mins < 0 || mins >= 60)
                return;

            int df = diff(hour, mins);
            if (df < diff) {
                diff = df;
                result = valid(hour) + ":" + valid(mins);
            }
        } else {
            for (int j = 0; j < 4; ++j) {
                ans[i] = digits[j];
                dfs(digits, i + 1, ans);
            }
        }
    }

    int diff(int hour, int minu) {
        int given = 60 * 60 - h * 60 - m;
        int our = 60 * 60 - hour * 60 - minu;
        return our < given ? given - our : given - our + 3600;
    }

    public String valid(int time) {
        if (time >= 0 && time <= 9) return "0" + time;
        else return time + "";
    }
}
