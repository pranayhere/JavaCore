package com.pranay.flipkart;

class MinBoats {
    public static void main(String[] args) {
        int[] weights = {10, 20, 30, 40};
        int boatLimit = 50;
        int maxPPl = 2;

        MinBoats mb = new MinBoats();
        int ans = mb.minBoats(weights, boatLimit, maxPPl, 0);
        System.out.println(ans);
    }

    public int minBoats(int[] weight, int maxWeight, int maxPpl, int idx) {
        if (maxPpl == 0)
            return 1;

        if (idx >= weight.length) {
            return 0;
        }

        int count = Integer.MAX_VALUE;

        if (maxWeight >= weight[idx]) {
            count += Math.min(count, Math.min(minBoats(weight, maxWeight - weight[idx], maxPpl - 1, idx + 1), minBoats(weight, maxWeight, maxPpl, idx + 1)));
        } else {
            count += Math.min(count, minBoats(weight, maxWeight, maxPpl, idx + 1));
        }

        System.out.println("returning :: " + maxWeight + "----" + maxPpl + "---" + idx + "---" + count);
        return count;
    }
}
