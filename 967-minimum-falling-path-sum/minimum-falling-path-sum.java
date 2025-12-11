class Solution {
    static int[][] dp;

    public int minFallingPathSum(int[][] matrix) {
        int n= matrix.length;
        dp = new int[n][n];
        for(int[] i: dp){
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        int ans = Integer.MAX_VALUE;
        for(int col=0; col<n; col++){
            ans = Math.min(ans, solve(0, col, matrix));
        }
        return ans;
    }

    public int solve(int row, int col, int[][] matrix) {
        int n= matrix.length;

        if(col < 0 || col >= n) return Integer.MAX_VALUE;

        // base case
        if(row == n-1){
            return matrix[row][col];
        }

        if(dp[row][col]!= Integer.MAX_VALUE){
            return dp[row][col];
        }

        int down = solve(row+1, col, matrix);
        int leftD = solve(row+1, col-1, matrix);
        int rightD = solve(row+1, col+1, matrix);

        dp[row][col] =matrix[row][col] +  Math.min(rightD, Math.min(down, leftD));
        return dp[row][col];
    
    }
}