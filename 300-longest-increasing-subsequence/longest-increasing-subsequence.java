class Solution {
    static int[][] dp;
    static int n;

    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n+1][n+1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0,-1,nums);
    }

    // TOP DOWN

    private static int solve(int i, int prev, int[] nums) {
        if(i>=n) return 0;

        if(prev!=-1 && dp[i][prev]!=-1) return dp[i][prev];


        int notTake = solve(i + 1, prev, nums);

        // Option 2: take (only if increasing)
        int take = 0;
        if (prev == -1 || nums[i] > nums[prev]) {
            take = 1 + solve(i + 1, i, nums);
        }
        if(prev!=-1){
        return dp[i][prev] = Math.max(take, notTake);

        }
        return Math.max(take, notTake);
    }
    // BOTTOM UP
    // private static int solve(int i, int prev, int[] nums) {
    //     if(i>=n) return 0;

    //     if(dp[i][prev+1]!=-1) return dp[i][prev+1];


    //     int notTake = solve(i + 1, prev, nums);

    //     // Option 2: take (only if increasing)
    //     int take = 0;
    //     if (prev == -1 || nums[i] > nums[prev]) {
    //         take = 1 + solve(i + 1, i, nums);
    //     }

    //     return dp[i][prev+1] = Math.max(take, notTake);
    // }
}