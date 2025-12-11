class Solution {
    static int[][] dp;

    public List<List<Integer>> generate(int numRows) {
        dp= new int[numRows][numRows];
        // for(int[] i : dp){
        //     Arrays.fill(i,0);
        

        List<List<Integer>> result = new ArrayList<>();

        for(int row=0; row< numRows; row++){
            List<Integer> curr = new ArrayList<>();
            for(int col=0; col<=row; col++){
                curr.add(solve(row, col));

            }
            result.add(curr);
        }
        return result;
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