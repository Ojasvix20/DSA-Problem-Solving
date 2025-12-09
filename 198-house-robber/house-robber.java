class Solution {
    static int[] dp;
    static int[] nums;

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return solve(0,nums); // start from 0
    }

    private static int solve(int i, int[] nums) {
        if (i >= nums.length)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        // choice1 : +2
        int rob = nums[i] + solve(i + 2, nums);

        // Choice 2: Skip  to next
        int skip = solve(i + 1, nums);

        return dp[i] = Math.max(rob, skip);
    }
}
