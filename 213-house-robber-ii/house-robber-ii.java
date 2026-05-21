class Solution {
    static int dp[];
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n]; 
        if(n==1){
            return nums[0];
        }   
        return Math.max(solve(1,n-1,nums),solve(0,n-2,nums));
    }
    public int solve(int start, int end, int nums[]){
        if(start>=nums.length){
            return 0;
        }
        if(start+1<=end){
            dp[start+1] = Math.max(nums[start],nums[start+1]);
        }
        dp[start] = nums[start];
        for(int i=2;i<=end;i++){
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[end];
    }
}