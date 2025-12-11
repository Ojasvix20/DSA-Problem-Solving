class Solution {
    static int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        dp = new int[n][n];
        for(int i =0 ; i< n;i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        return solve(triangle, 0,0);

    }
    public static int solve(List<List<Integer>> triangle, int i, int row){
        if(row==triangle.size()-1){
            return triangle.get(row).get(i);
        }
        if (dp[row][i] != Integer.MIN_VALUE) {
            return dp[row][i];
        }

        int op1= triangle.get(row).get(i) + solve(triangle, i, row+1);
        int op2= triangle.get(row).get(i) + solve(triangle, i+1, row+1);
        dp[row][i] = Math.min(op1, op2);
        return dp[row][i];
    }
}