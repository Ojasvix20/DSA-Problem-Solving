class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }
        int maxSum= currSum;
        int l = 0, r = k - 1;
        while (r < nums.length-1) {
            currSum -= nums[l];
            l++;
            r++;
            currSum += nums[r];

            maxSum = Math.max(currSum, maxSum);
        }
        return (double)maxSum/k;
    }
}