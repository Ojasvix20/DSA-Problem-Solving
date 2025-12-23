class Solution {
    static int[][] dp;
    static int m;
    static int n;

    public int minDistance(String word1, String word2) {
        
        m= word1.length();
        n= word2.length();
        dp = new int[m+1][n+1];
        solve(word1, word2);

        return n-dp[m][n]+m-dp[m][n];
    }
    private static void solve(String word1, String word2) {

        for(int i=1; i<=m;i++){
            for(int j=1; j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = 1+  dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
    }
}