package com.pranay.interview.dp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Location {
    public long pickup;
    public long dropoff;
    public int tip;

    public Location(Long p, Long d, Integer t) {
        pickup = p;
        dropoff = d;
        tip = t;
    }

    @Override
    public String toString() {
        return "Location{" +
                "pickup=" + pickup +
                ", dropoff=" + dropoff +
                ", tip=" + tip +
                '}';
    }
}

public class SwiggyRevenue {
    public static void main(String[] args) {
//        List<Long> pickup = Arrays.asList(11L, 30L, 0L, 21L, 41L, 19L);
//        List<Long> dropoff = Arrays.asList(20L, 31L, 17L, 22L, 46L, 21L);
//        List<Integer> tip = Arrays.asList(6, 1, 9, 0, 8, 0);
//        ans = 44

//        List<Long> pickup = Arrays.asList(696L,771L,2099L,5989L,8647L,1620L,5004L,4815L,6383L,2765L,594L,2233L,2239L,4672L,2409L,5460L,77L,1102L,5778L,6000L,3427L,9L,502L,5769L,66L,2053L,4823L,230L,724L,1602L,533L,3585L,5040L,5680L,39L,2870L,4320L,1791L,5764L,1119L,3650L,4689L,2049L,1017L,1624L,311L,8372L,7608L,259L,3398L,4727L,1016L,700L,2831L,2369L,6838L,569L,1458L,6750L,121L,4176L,1184L,1325L,4858L,4684L,662L,3212L,273L,30L,2048L,1492L,4045L);
//        List<Long> dropoff = Arrays.asList(5957L,7624L,3776L,6780L,8982L,5315L,9132L,6516L,9911L,9731L,1138L,9036L,2425L,8085L,3457L,5461L,356L,8472L,5796L,8411L,4095L,6529L,4661L,7184L,8741L,4121L,7895L,8013L,3374L,6631L,7628L,8105L,7527L,6338L,117L,6251L,8175L,9199L,6967L,1240L,7592L,5418L,8944L,5984L,4946L,3353L,9252L,8522L,9174L,6334L,9024L,6192L,3406L,8218L,2386L,7588L,1677L,7839L,7495L,175L,8961L,5644L,2686L,5013L,6904L,3076L,3941L,5207L,2747L,3785L,3381L,7842L);
//        List<Integer> tip = Arrays.asList(6761,76099,55818,96419,38221,39280,54108,83677,26106,81591,65837,42611,71275,74855,67559,54416,8481,7887,20397,41010,83818,38274,33738,27771,87830,67190,68016,70568,48985,31126,50370,5093,10052,58094,95041,72819,7988,12795,22254,11241,46216,99168,31463,93110,21442,55662,54353,27033,34700,99959,44273,74237,31924,87057,78889,85286,27707,66558,46014,71707,67560,68187,3066,16204,21918,82351,87627,48075,81387,19198,5390,98143);
//        ans = 825001

//        List<Long> pickup = Arrays.asList(590L,2676L,6543L,2787L,8304L,3653L,3279L,9445L,2048L,1686L,2821L,521L,1634L,797L,856L,1835L,2840L,1256L,1269L,1579L,1942L,1369L,164L,7464L,524L,3556L,2043L,5492L,2500L,354L,331L,262L,4526L,7712L,3970L,112L,3292L,5452L,4612L,3119L,4247L,2993L,4929L,5359L,6526L,3244L,3938L,1182L,3460L,3197L,1008L,801L,775L,1190L,4594L,2253L,8842L,5097L,2416L,1993L,759L,1324L,857L,1069L,2021L,6541L,4566L,2713L,2818L,152L,855L,4663L,3845L,6680L,6604L,1754L,5809L,1209L,2438L,6796L,247L,3519L,4415L,846L,7830L,6436L,2029L,5531L);
//        List<Long> dropoff = Arrays.asList(6830L,6997L,8789L,6474L,8761L,7094L,3541L,9485L,8660L,9166L,7821L,8198L,6123L,6803L,7316L,3388L,7165L,6533L,5846L,3789L,3933L,3639L,8727L,8825L,3835L,5755L,7594L,6265L,3829L,2693L,7876L,5181L,8384L,8477L,7887L,9572L,4850L,5935L,6478L,6355L,8059L,4130L,7159L,6982L,9193L,4817L,4473L,3635L,4226L,8309L,1541L,4606L,7531L,5411L,5157L,7956L,9157L,5250L,2832L,2844L,8455L,6399L,6398L,3135L,2622L,8405L,7649L,7906L,4882L,4910L,1399L,8578L,4882L,9703L,8750L,6439L,5920L,3218L,9926L,7464L,2305L,4272L,6956L,6900L,9659L,8779L,6550L,8124L);
//        List<Integer> tip = Arrays.asList(10074,52604,81507,59827,67385,31851,28012,57337,18093,31239,5413,18948,70015,6921,54836,2508,636,5819,17567,36387,87049,87693,7100,59575,46634,15854,32004,29627,10337,89765,46050,42658,23007,56066,538,19835,87341,5436,79927,67248,96654,33270,62362,73298,31676,96338,79045,64538,46655,14198,85259,88739,8782,48809,25929,12733,59970,66559,14510,300,78121,46550,39447,31639,11212,99369,31316,27076,87251,48020,45966,87575,28235,79431,26598,69085,8304,41187,33642,81155,3420,74169,4171,56231,81231,33781,25475,80915);
//        ans = 618851

        List<Long> pickup = Arrays.asList(0L, 4L, 5L);
        List<Long> dropoff = Arrays.asList(3L, 5L, 7L);
        List<Integer> tip = Arrays.asList(1, 2, 2);
//        ans = 11

        SwiggyRevenue sr = new SwiggyRevenue();
        long earning = sr.maxEarning(pickup, dropoff, tip);
        System.out.println("Max Earning : " + earning);
    }

    long maxAmt = 0L;
    List<Location> locations = new ArrayList<>();
    private long maxEarning(List<Long> pickup, List<Long> dropoff, List<Integer> tip) {
        for (int i = 0; i < pickup.size(); i++) {
            locations.add(new Location(pickup.get(i), dropoff.get(i), tip.get(i)));
        }

        Collections.sort(locations, (a, b) -> (int) (a.pickup == b.pickup ? a.pickup - b.pickup : a.dropoff - b.dropoff));

        dfs(locations, 0, 0, -1);
        long ans = dfs2(locations, locations.size(), -1);

        System.out.println("Ans :::::: " + ans);
        return maxAmt;
    }

    // correct
    private void dfs(List<Location> locations, int idx, long amt, int prev) {
        if (idx == locations.size()) {
            maxAmt = Math.max(amt, maxAmt);
            return;
        }

        Location l = locations.get(idx);
        long earnings = (l.dropoff - l.pickup) + l.tip;

        dfs(locations, idx + 1, amt, prev);

        if (prev == -1 || locations.get(prev).dropoff <= locations.get(idx).pickup) {
            dfs(locations, idx + 1, amt + earnings, idx);
        }
    }

    // wrong
    private long dfs2(List<Location> locations, int idx, int prev) {
        if (idx == 0)
            return 0;

        Location l = locations.get(idx - 1);
        long earnings = (l.dropoff - l.pickup) + l.tip;

        long amt = 0;

        if (prev == -1 || locations.get(idx - 1).dropoff <= locations.get(prev).pickup) {
            amt = earnings + dfs2(locations, idx - 2, idx - 1);
        }

        amt = Math.max(amt, dfs2(locations, idx - 2, prev));
        return amt;
    }
}
