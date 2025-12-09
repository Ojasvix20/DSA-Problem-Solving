class Solution {
    static int[] dp;
    static int[] nums;

    public int rob(int[] arr) {
        nums = arr;
        dp = new int[arr.length];
        Arrays.fill(dp, -1);

        return solve(0); // start from 0
    }

    private static int solve(int i) {
        if (i >= nums.length)
            return 0;

        if (dp[i] != -1)
            return dp[i];

        // choice1 : +2
        int rob = nums[i] + solve(i + 2);

        // Choice 2: Skip  to next
        int skip = solve(i + 1);

        return dp[i] = Math.max(rob, skip);
    }
}
