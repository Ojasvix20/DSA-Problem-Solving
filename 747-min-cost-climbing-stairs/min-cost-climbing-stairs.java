class Solution {
    static int[] dp;
    static int n;
    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        dp = new int[n+1];
        // Arrays.fill(dp, -1);
        return Math.min(solve(cost,0), solve(cost,1));
    }

    // //TOP DOWN:-
    // private static int solve(int[] cost, int i ){
    //     if(i>=n) return 0;

    //     if(dp[i]!=-1) return dp[i];

    //     dp[i] = cost[i] +  Math.min(solve(cost, i+1), solve(cost, i+2));
    //     return dp[i];
    // }


    // //BOTTOM UP:-
    private static int solve(int[] cost, int i ){
        if(i>=n) return 0;

        dp[0]=0;
        dp[1]=0;

        for(int k=2; k<=n; k++){
            dp[k]= Math.min(dp[k-1] + cost[k-1], dp[k-2] + cost[k-2]);
        }
        return dp[n];
    }
}