class Solution {
    static int[] dp;
    static int[] nums;

    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        // return solve(0, nums); // start from 0
        return solve( nums); // start from 0
    }

    // TOP DOWN: 
    // private static int solve(int i, int[] nums) {
    //     if (i >= nums.length)
    //         return 0;

    //     if (dp[i] != -1)
    //         return dp[i];

    //     // choice1 : +2
    //     int rob = nums[i] + solve(i + 2, nums);

    //     // Choice 2: Skip  to next
    //     int skip = solve(i + 1, nums);

    //     return dp[i] = Math.max(rob, skip);
    // }

    // BOTTOM UP
    private static int solve(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(
                    dp[i - 1], // skip curr house
                    nums[i] + dp[i - 2] // rob curr house
            );
        }

        return dp[n - 1];
    }
}
