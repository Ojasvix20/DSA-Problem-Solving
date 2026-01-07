class Solution {
    static int[][] dp;
    static int n;

    public int findLongestChain(int[][] pairs) {
        n = pairs.length;
        dp = new int[n ][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        return solve(0, -1, pairs);
    }

    public static int solve(int i, int prev, int[][] pairs) {
        if (i >= n)
            return 0;

        if (dp[i][prev+1] != -1)
            return dp[i][prev+1];

        int notTake = solve(i + 1, prev, pairs);
        int take = 0;
        if (prev == -1 || pairs[i][0] > pairs[prev][1]) {
            take = 1 + solve(i + 1, i, pairs);
        }
        return dp[i][prev+1] = Math.max(take, notTake);
    }
}