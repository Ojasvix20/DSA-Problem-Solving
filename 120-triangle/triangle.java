class Solution {
    static int[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        // return solve(triangle, 0, 0);
        //for bottom up fn call:
        return solve(triangle);
    }

    // //top down approach:
    // public static int solve(List<List<Integer>> triangle, int i, int row){
    //     if(row==triangle.size()-1){
    //         return triangle.get(row).get(i);
    //     }
    //     if (dp[row][i] != Integer.MIN_VALUE) {
    //         return dp[row][i];
    //     }

    //     int op1= triangle.get(row).get(i) + solve(triangle, i, row+1);
    //     int op2= triangle.get(row).get(i) + solve(triangle, i+1, row+1);
    //     dp[row][i] = Math.min(op1, op2);
    //     return dp[row][i];
    // }

    //// Bottom up approach - wrong please work on it
    // public static int solve(List<List<Integer>> triangle) {

    //     dp[0][0] = triangle.get(0).get(0);

    //     //fill left boundary: 
    //     for (int i = 1; i < triangle.size(); i++) {
    //         dp[i][0] = triangle.get(i - 1).get(0) + triangle.get(i).get(0);
    //     }
    //     // fill right boundary
    //     for (int j = 1; j < triangle.size(); j++) {
    //         dp[0][j] = triangle.get(0).get(j - 1) + triangle.get(0).get(j);
    //     }

    //     for (int i = 1; i < triangle.size(); i++) {
    //         for (int j = 1; j < triangle.get(i).size(); j++) {
    //             dp[i][j] = Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1))
    //                     + triangle.get(i).get(j);
    //         }
    //     }

    //     int ans = Integer.MIN_VALUE;
    //     for (int col = 0; col < triangle.get(triangle.size() - 1).size(); col++) {
    //         ans = Math.min(triangle.get(triangle.size() - 1).get(col), ans);
    //     }
    //     return ans;
    // }

    //outsourced
    public static int solve(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // copy last row into dp
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }

        // build from second last row
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                dp[row][col] = triangle.get(row).get(col)
                        + Math.min(dp[row + 1][col],
                                dp[row + 1][col + 1]);
            }
        }

        return dp[0][0];
    }

}