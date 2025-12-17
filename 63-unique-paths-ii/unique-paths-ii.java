class Solution {
    static int[][] dp;
    static int m;
    static int n;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        dp = new int[m][n];
        // for(int[] i : dp){
        //     Arrays.fill(i,-1);
        // }

        // return countWays(obstacleGrid, 0, 0);
        return solve(obstacleGrid);
    }

    // static int countWays(int[][] maze, int r, int c) {

    //     // Out of bounds i.e. no path
    //     if (r >= m || c >= n) return 0;

    //     // If cell has obstacle = no path
    //     if (maze[r][c] == 1) return 0;

    //     // Reached destination 
    //     if (r == m - 1 && c == n) return 1;

    //     if(dp[r][c]!=-1) return dp[r][c];

    //     // Move Down
    //     int down = countWays(maze, r + 1, c);

    //     // Move Right
    //     int right = countWays(maze, r, c + 1);

    //     return dp[r][c] = down + right;
    // }
    // Tabulation - bottom up
    private static int solve(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        dp[0][0] = 1;
        for (int j = 1; j < n; j++){
            if(obstacleGrid[0][j]==1){
                dp[0][j]=0;
            }else{
                dp[0][j] = dp[0][j - 1];;
            }
        }
        for (int i = 1; i < m; i++){
            if(obstacleGrid[i][0]==1){
                dp[i][0]=0;
            }
            else{
                dp[i][0] = dp[i - 1][0];
            }
        }


        for(int i = 1;i<m;i++){
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m-1][n-1];
    }
}
