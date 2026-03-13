class Solution {
    static int[][] dp;
    static int n;

    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n + 1][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        
        return solve(-1, 0, nums);

        
    }

    public static int solve(int prev, int i, int[] nums) {
        if (i >= n)
            return 0;
        if (dp[i][prev+1] != -1)
            return dp[i][prev+1];

        // not take:
        int notTake = solve(prev, i + 1, nums);
        int take = Integer.MIN_VALUE;
        //take if larger val
        if (prev == -1 || nums[i] > nums[prev]) {
            take = 1 + solve(i, i + 1, nums);
        }
        return dp[i][prev+1] = Math.max(take, notTake);
    }
}