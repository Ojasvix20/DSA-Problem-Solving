class Solution {
    static int[][] dp;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        // for (int[] row : dp)
        //     Arrays.fill(row, -1);
        // return solve(m, n, 0, 0);

        return solve(m,n);
    }

    // private static int solve(int m, int n, int i, int j) {
    //     if (i == m - 1 && j == n - 1) {
    //         return 1;
    //     }

    //     if (i >= m || j >= n)
    //         return 0;
    //     if (dp[i][j] != -1) {
    //         return dp[i][j];
    //     }
    //     int right = solve(m, n, i, j + 1);
    //     int down = solve(m, n, i + 1, j);
    //     return dp[i][j] = right + down;
    // }

    // Tabulation - bottom up
    private static int solve(int m, int n) {
        for (int j = 0; j < n; j++) dp[0][j] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}

// 
