class Solution {
    static int m;
    static int[] group;
    static int[] profit;

    static int[][][] dp;
    static int n;
    int MOD = 1000000007;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        m = profit.length;
        this.profit = profit;
        this.group = group;
        this.n=n;
        dp=new int[m][n+1][minProfit+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<=minProfit;k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        int ways = solve(0, 0, 0,minProfit);
        return ways;
    }

    public int solve(int i, int currProfit, int mens, int minProfit){
        if(mens>n) return 0;
        if(i==m){
            return (currProfit>=minProfit)? 1: 0;
        }

        currProfit = Math.min(currProfit, minProfit);

        if(dp[i][mens][currProfit] != -1)
            return dp[i][mens][currProfit];

        int notTake=solve(i+1, currProfit, mens, minProfit);
        int take=solve(i+1, Math.min(currProfit + profit[i], minProfit), mens+group[i], minProfit);
        return dp[i][mens][currProfit]= (take+notTake)%MOD;
    }
}