class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {

        long[] arr = { cost1, cost2, costBoth, need1, need2 };

        if (need1 == 0 && need2 == 0)
            return 0;

        long costSeparate = (long) need1 * cost1 + (long) need2 * cost2;

        long ans = costSeparate;

        long bothMin = Math.min(need1, need2);

        long costMinBoth = bothMin * costBoth + (need1 - bothMin) * cost1 + (need2 - bothMin) * cost2;

        ans = Math.min(ans, costMinBoth);

        long bothMax = Math.max(need1, need2);
        long costMaxBoth = bothMax * costBoth;
        ans = Math.min(ans, costMaxBoth);

        return ans;

    }
}