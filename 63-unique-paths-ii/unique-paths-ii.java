class Solution {
    static int[][]dp;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new int[m][n];
        for(int[] i : dp){
            Arrays.fill(i,-1);
        }

        return countWays(obstacleGrid, 0, 0);
    }

    static int countWays(int[][] maze, int r, int c) {

        // Out of bounds i.e. no path
        if (r >= maze.length || c >= maze[0].length) return 0;

        // If cell has obstacle = no path
        if (maze[r][c] == 1) return 0;

        // Reached destination 
        if (r == maze.length - 1 && c == maze[0].length - 1) return 1;

        if(dp[r][c]!=-1) return dp[r][c];

        // Move Down
        int down = countWays(maze, r + 1, c);

        // Move Right
        int right = countWays(maze, r, c + 1);

        return dp[r][c] = down + right;
    }
}
