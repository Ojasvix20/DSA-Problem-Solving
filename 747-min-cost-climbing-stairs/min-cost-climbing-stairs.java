class Solution {
    static int[] dp;
    static int n;
    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(solve(cost,0), solve(cost,1));
    }
    private static int solve(int[] cost, int i ){
        if(i>=n) return 0;

        if(dp[i]!=-1) return dp[i];

        dp[i] = cost[i] +  Math.min(solve(cost, i+1), solve(cost, i+2));
        return dp[i];
    }
}