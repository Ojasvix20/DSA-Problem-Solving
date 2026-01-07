class Solution {
    static int n;
    static int[][] dp;

    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n+1][2];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return solve(0, 1, prices);

    }

    public int solve(int i, int buy, int[] prices) {
        if (i >= n)
            return 0;

        if (dp[i][buy] != -1)
            return dp[i][buy];

        if (buy==1) {
            return dp[i][buy] = Math.max((-prices[i] + solve(i + 1, 0, prices)),
                    (0 + solve(i + 1, 1, prices)));
        } else {
            return dp[i][buy] = Math.max((prices[i] + solve(i + 2, 1, prices)),
                    (0 + solve(i + 1, 0, prices)));

        }
    }
}