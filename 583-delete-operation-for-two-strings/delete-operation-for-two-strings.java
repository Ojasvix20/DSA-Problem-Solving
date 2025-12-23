class Solution {
    static int[][] dp;
    static int m;
    static int n;

    public int minDistance(String word1, String word2) {
        
        m= word1.length();
        n= word2.length();
        // dp = new int[m+1][n+1];
        dp = new int[m][n];
        for(int row[] :dp){
            Arrays.fill(row,-1);
        }

        int lcs = solve(word1, word2,0,0);

        return n- lcs +m- lcs ;
    }
    // Bottom up
    // private static void solve(String word1, String word2) {

    //     for(int i=1; i<=m;i++){
    //         for(int j=1; j<=n;j++){
    //             if(word1.charAt(i-1)==word2.charAt(j-1)){
    //                 dp[i][j] = 1+  dp[i-1][j-1];
    //             }else{
    //                 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    //             }
    //         }
    //     }
    // }


    private static int solve(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];

        if (text1.charAt(i) == text2.charAt(j)) {

            dp[i][j] =  1 + solve(text1, text2, i + 1, j + 1);
        } else {
            dp[i][j] =  Math.max(solve(text1, text2, i + 1, j), solve(text1, text2, i, j + 1));
        }
        return dp[i][j];
    }

}