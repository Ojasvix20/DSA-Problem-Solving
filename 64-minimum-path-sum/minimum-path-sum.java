class Solution {
    static int[][] dp;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        //memo fn call
        // return solve(0, 0, m, n, grid);
        
        
        //tabulation fn call:
        return solve(m, n, grid);

    }

    // Memoization - Top Down:
    // public int solve(int i, int j,int m, int n, int[][] grid) {
    //     if(i==m-1 && j==n-1){
    //         return grid[i][j];
    //     }

    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int down = Integer.MAX_VALUE;
    //     if(i+1<m){
    //         down = solve(i+1, j ,m , n , grid);
    //     }
    //     int right= Integer.MAX_VALUE;
    //     if(j+1<n){
    //         right = solve(i, j+1 ,m , n , grid);
    //     }

    //     dp[i][j] = grid[i][j] +  Math.min(right,down);
    //     return dp[i][j];
    // }

    // Tabulation - bottom up:
    private static int solve(int m, int n, int[][] grid) {
        dp[0][0] = grid[0][0];
        //fill for boundary rows:
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        // Fill boundary column - only can come from top
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }


}