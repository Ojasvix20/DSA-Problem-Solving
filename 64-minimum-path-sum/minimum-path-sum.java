class Solution {
    static int[][] dp;

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0,m, n, grid);

    }

    public int solve(int i, int j,int m, int n, int[][] grid) {
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down = Integer.MAX_VALUE;
        if(i+1<m){
            down = solve(i+1, j ,m , n , grid);
        }
        int right= Integer.MAX_VALUE;
        if(j+1<n){
            right = solve(i, j+1 ,m , n , grid);
        }

        dp[i][j] = grid[i][j] +  Math.min(right,down);
        return dp[i][j];
    }
}