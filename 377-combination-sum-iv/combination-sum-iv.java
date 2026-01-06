class Solution {
    Integer[] dp;

    public int combinationSum4(int[] nums, int target) {
        dp = new Integer[target + 1];
        return solve(nums, target);
    }

    private int solve(int[] nums, int t) {
        if (t == 0) return 1;
        if (t < 0) return 0;

        if (dp[t] != null) return dp[t];

        int count = 0;
        for (int num : nums) {
            count += solve(nums, t - num);
        }

        return dp[t] = count;
    }
}
