class Solution {
    public int climbStairs(int n) {
        //BASIC RECURSION : 
        // if(n<=1) return 1;
        // return climbStairs(n-1) + climbStairs(n-2); 

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        // return solveTopDown(n, dp);
        // return solveBottomUp(n, dp);
        return solveSpaceOptimized(n);

    }
    // TOP DOWN
    private int solveTopDown(int n, int[] dp) {
        if (n <= 1) return 1;

        if (dp[n] != -1) return dp[n];

        dp[n] = solveTopDown(n-1, dp) + solveTopDown(n-2, dp);
        return dp[n];
    }
    // Bottom Up:
    private int solveBottomUp(int n, int[] dp) {

        if (n <= 1) return 1;
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];

        }
        return dp[n];

    }
    private int solveSpaceOptimized(int n) {

        if (n <= 1) return 1;
        int p1=1;
        int p2=1;
        int ans=0;
        for(int i=2;i<=n;i++){
           ans = p1 + p2;
           p1=p2;
           p2=ans;

        }
        return ans;

    }


}