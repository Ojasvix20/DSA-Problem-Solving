// class Solution {
//     public int minInsertions(String s) {
//         int n = s.length();
//         String rev = new StringBuilder(s).reverse().toString();

//         int[][] dp = new int[n + 1][n + 1];

//         // LCS between s and reverse(s)
//         //bottom up
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= n; j++) {
//                 if (s.charAt(i - 1) == rev.charAt(j - 1)) {
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                 } else {
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                 }
//             }
//         }

//         int lps = dp[n][n];
//         return n - lps;
//     }
// }

class Solution {
    static int[][] dp;

    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n][n];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solve(0, s.length() - 1, s);
    }

    private static int solve(int i, int j, String s) {
        if (i >= j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = solve(i + 1, j - 1, s);
        }
        return dp[i][j] = 1 + Math.min(solve(i + 1, j, s), solve(i, j - 1, s));
    }
}