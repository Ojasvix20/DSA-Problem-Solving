class Solution {
    static int[] dp;

    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, s);
    }

    private int solve(int i, String s) {
        if (i == s.length())
            return 1;

        if (s.charAt(i) == '0')
            return 0;

        if (dp[i] != -1)
            return dp[i];

        int ways = 0;

        // 1 digit
        ways += solve(i + 1, s);

        //2 dig
        if (i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i + 2));
            if (num >= 10 && num <= 26) {
                ways += solve(i + 2, s);
            }
        }

        return dp[i] = ways;
    }
}
