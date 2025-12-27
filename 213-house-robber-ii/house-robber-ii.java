// if we start from 0th index house, we go upto the second last house.
// if we start from 1st index house, we go upto the last house.
class Solution {
    static int[] dp1;
    static int[] dp2;
    public int rob(int[] nums) {
        int n= nums.length;
        if(n==1) return nums[0];
        dp1=new int[nums.length];
        dp2=new int[nums.length];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        
        //take 0th house, and dont take last house
        int op1 = solve(0, n-2, nums, dp1);
            //dont take 0th house, take afterwards
        int op2 = solve(1, n-1, nums, dp2);

        return Math.max(op1, op2);
    }
    private static int solve(int i, int last, int[] nums, int[] dp){
        if(i>last) return 0;

        if(dp[i]!=-1) return dp[i];

        int skip= solve(i+1, last, nums, dp);

        // take ith house
        int take= nums[i] + solve(i+2, last, nums, dp);

        return dp[i] = Math.max(take, skip);
    }
}