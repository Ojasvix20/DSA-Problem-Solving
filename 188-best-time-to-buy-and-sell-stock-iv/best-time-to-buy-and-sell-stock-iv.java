class Solution{
        public int maxProfit( int k , int[] prices) {
            int n= prices.length;
            int[][][] dp=  new int[n+1][2][k+1];

            for(int i=n-1;i>=0;i--){
                for(int buy=0; buy<=1; buy++){
                    for(int cap=1; cap<=k; cap++){

                        if(buy==1){
                            dp[i][buy][cap] =  Math.max((-prices[i] + dp[i+1][0][cap]), (0 + dp[i+1][1][cap]));
                        }else{
                            dp[i][buy][cap] =  Math.max((prices[i] + dp[i+1][1][cap-1]), ( dp[i+1][0][cap]));
                        }
                    }
                }
            }
            return dp[0][1][k];

        }

    }
    // class Solution {
//     static int n;
//     static int[][][] dp;

//     public int maxProfit(int k, int[] prices) {
//         n = prices.length;
//         dp = new int[n][2][k+1];
//         for (int i = 0; i < n; i++)
//             for (int buy = 0; buy < 2; buy++)
//                 Arrays.fill(dp[i][buy], -1);
//         return solve(0, k, 1, prices);
//     }

//     // TOP DOWN:
//     public int solve(int i, int cap, int buy, int[] prices) {
//         if (cap == 0)
//             return 0;
//         if (i == n)
//             return 0;

//         if(dp[i][buy][cap]!=-1) return dp[i][buy][cap];

//         if (buy==1) {
//             return dp[i][buy][cap] =  Math.max((-prices[i] + solve(i + 1, cap, 0, prices)), (0 + solve(i + 1, cap, 1, prices)));
//         }else{
//             return dp[i][buy][cap] = Math.max((prices[i] + solve(i + 1, cap-1, 1, prices)), (0 + solve(i + 1, cap, 0, prices)));

//         }
//     }
// }