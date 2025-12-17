class Solution {
    static int[][] dp;
    public List<Integer> getRow(int rowIndex) {
        dp= new int[rowIndex+1][rowIndex+1];
        // for(int[] i : dp){
        //     Arrays.fill(i,0);
        

        List<Integer> row = new ArrayList<>();

        for (int col = 0; col <= rowIndex; col++) {
            row.add(solve(rowIndex, col));
        }

        return row;

    }
    private static int solve(int row, int col ){
        if(col==0 || col==row){
            return 1;
        }
        if(dp[row][col]!=0) return dp[row][col];

        dp[row][col] = solve(row - 1, col - 1) + solve(row - 1, col);

        return dp[row][col];

    }
}