class Solution {
    static int n;
    static long[][] dp;
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        dp = new long[n][2];
        for(long[] i: dp){
            Arrays.fill(i,-1);
        }
        return solve(0,nums,1);
    }
    private static long solve(int i, int[] nums, int flag){
        if(i>=n) return 0;
        int f= (flag==1) ?1:0;
        if(dp[i][f]!=-1) return dp[i][f];
        long skip = solve(i+1, nums,flag);
        long take;
        if (flag == 1) {
            take = nums[i] + solve(i + 1, nums, 0);
        } else {
            take = -nums[i] + solve(i + 1, nums, 1);
        }

        return dp[i][flag] = Math.max(skip, take);
        
    }
}