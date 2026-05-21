class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(0,target,nums);        
    }
    public static int solve(int i, int target, int nums[]){
        if(i==nums.length){
            return (target==0?1:0);
        }
        int plus = solve(i+1,target+nums[i],nums);
        int minus = solve(i+1,target-nums[i],nums);
        return plus + minus;
    }
}