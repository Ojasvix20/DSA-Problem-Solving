class Solution {
    static int[] dp;
    public int tribonacci(int n) {
        dp = new int[n+1];
        // Arrays.fill(dp, -1);
        return solve(n);
    }
    // static int solve(int n){
    //     if(n==0) return 0;
        
    //     if(n==1) return 1;
        
    //     if(n==2) return 1;
        
    //     if(dp[n] != -1) return dp[n];
    //     dp[n] = solve(n-3) + solve(n-2) + solve(n-1);
    //     return dp[n];
    // }

    // Bottom up:
    static int solve(int n){
        if(n==0) return 0;
        
        if(n==1) return 1;
        
        if(n==2) return 1;
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3; i<=n;i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        return dp[n];
    }
}