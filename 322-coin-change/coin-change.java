class Solution {
    static int[][] dp;
    static int n;
    static int INF = (int)1e9;


    public int coinChange(int[] coins, int amount) {
        n = coins.length;
        dp = new int[n][amount + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);

        int ans = solve(0, coins, amount);
        return ans >= INF ? -1 : ans;
    }

    static int solve(int i, int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (i == n)
            return Integer.MAX_VALUE;

        if (dp[i][amount] != -1)
            return dp[i][amount];

        int take = INF;
        if (coins[i] <= amount) {
            take = 1 + solve(i, coins, amount - coins[i]);
        }
        int skip = solve(i + 1, coins, amount);
        dp[i][amount] = Math.min(take, skip);

        return dp[i][amount];
    }
}