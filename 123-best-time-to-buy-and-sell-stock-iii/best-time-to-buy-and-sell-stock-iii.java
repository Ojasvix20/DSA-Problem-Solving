class Solution {
    static int n;
    static int[][][]dp;

    public int maxProfit(int[] prices) {
        n= prices.length;
        dp= new int[n][2][3];
        for (int i = 0; i < n; i++)
            for (int b = 0; b < 2; b++)
                Arrays.fill(dp[i][b], -1);
        return solve(0,2,true, prices);
    }

    public int solve(int i, int cap, boolean buy, int[] prices) {
        if (cap == 0)
            return 0;
        if (i == n)
            return 0;
        int b = buy? 1:0;
        if(dp[i][b][cap]!=-1) return dp[i][b][cap];

        if (buy) {
            return dp[i][b][cap] =  Math.max((-prices[i] + solve(i + 1, cap, false, prices)), (0 + solve(i + 1, cap, true, prices)));
        }else{
            return dp[i][b][cap] = Math.max((prices[i] + solve(i + 1, cap-1, true, prices)), (0 + solve(i + 1, cap, false, prices)));

        }
    }
}