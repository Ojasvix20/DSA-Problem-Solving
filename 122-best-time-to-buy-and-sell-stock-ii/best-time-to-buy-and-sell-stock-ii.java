// class Solution {

//     static int[][] dp;
//     static int n;

//     public int maxProfit(int[] prices) {
//         n=prices.length;
//         dp = new int[n][2];
//         for(int[] a:dp){
//         Arrays.fill(a,-1);
//         }
//         return solve(0,prices,1);
//     }

//     private static int solve(int i, int[] prices, int buy) {
//         if (i == n)
//             return 0;

//         if (dp[i][buy] != -1)
//             return dp[i][buy];
//         int profit=0;
//         if (buy == 1) {
//             profit = Math.max((-prices[i] + solve(i + 1, prices, 0)), (0 + solve(i + 1, prices, 1)));
//         } else {
//             profit = Math.max((prices[i] + solve(i + 1, prices, 1)), (0 + solve(i + 1, prices, 0)));
//         }
//         return dp[i][buy] = profit;
//     }

// }

// Bottom up:
// class Solution {

//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][] dp = new int[n + 1][2];

//         // base case already 0 by default
//         // dp[n][0] = dp[n][1] = 0;

//         for (int i = n - 1; i >= 0; i--) {
//             // buy == 1
//             dp[i][1] = Math.max(
//                 -prices[i] + dp[i + 1][0],
//                 dp[i + 1][1]
//             );

//             // buy == 0
//             dp[i][0] = Math.max(
//                 prices[i] + dp[i + 1][1],
//                 dp[i + 1][0]
//             );
//         }

//         return dp[0][1];
//     }
// }

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        // base case
        dp[0][1] = -prices[0];
        dp[0][0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(
                dp[i - 1][1],
                dp[i - 1][0] - prices[i]
            );

            dp[i][0] = Math.max(
                dp[i - 1][0],
                dp[i - 1][1] + prices[i]
            );
        }

        return dp[n - 1][0]; // final profit when NOT holding stock
    }
}
