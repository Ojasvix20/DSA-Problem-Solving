class Solution {
    static int n;
    static int[][] dp;

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        n = words.length;
        dp = new int[n+1][n+1];
        for(int[] row: dp) Arrays.fill(row,-1);

        return solve(0, -1, words);
    }

    public static int solve(int i, int prev, String[] words) {
        if (i == n)
            return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];

        int notTake = solve(i + 1, prev, words);
        int take = 0;
        if (prev==-1 || isValid(words[prev], words[i])) {
            take = 1 + solve(i + 1, i, words);
        }

        return dp[i][prev+1] = Math.max(take, notTake);
    }

    public static boolean isValid(String a, String b) {
        int x = a.length();
        int y = b.length();

        if (y - 1 == x) {
            int i = 0, j = 0;
            while (i < x && j < y) {
                if (a.charAt(i) == b.charAt(j)) {
                    i++;
                    j++;
                } else if (a.charAt(i) != b.charAt(j)) {
                    j++;
                }
            }
            return i==x;
        }
        return false;
    }
}