class Solution {
    
    public int fib(int n) {
        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // Top DOwn Approach: 
        // if (n <= 1) return n;

        // if (dp[n] != -1) return dp[n];

        // dp[n] = fib(n-1) + fib(n-2);
        // return dp[n];

        // 
        // Bottom up:
        // if(n<=1) return n;
        // dp[0]=0;
        // dp[1]=1;
        // for(int i=2; i<=n; i++){
        //     dp[i]=dp[i-1]+ dp[i-2];
        // }
        // return dp[n];
    
        //basic:
        int p1=0;
        int p2=1;
        if(n<=1) return n;
        int curr=0;

        for(int i=2; i<=n ;i++){
            curr = p2+p1;
            p1=p2;
            p2=curr;
            
        }
        return curr;
    
    }
}