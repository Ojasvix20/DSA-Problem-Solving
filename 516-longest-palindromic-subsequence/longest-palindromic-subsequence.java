class Solution {
    static int[][] dp;
    static int n;

    public int longestPalindromeSubseq(String s) {
        n = s.length();
        dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(0, n - 1, s);
    }

    private static int solve(int i, int j, String s) {
        if (i > j)
            return 0;
        if (i == j)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];

        int notTake = Math.max(solve(i + 1, j, s), solve(i, j - 1, s));

        int take = 0;
        if (s.charAt(i) == s.charAt(j)) {
            take = 2 + solve(i + 1, j - 1, s);
        }

        return dp[i][j] = Math.max(take, notTake);
    }
}