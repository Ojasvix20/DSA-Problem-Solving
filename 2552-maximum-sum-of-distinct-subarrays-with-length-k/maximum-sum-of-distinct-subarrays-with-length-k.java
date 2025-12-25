class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int l = 0;
        int r = 0;
        long sum = 0;
        long maxSum = 0;
        while (r < nums.length) {
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
            set.add(nums[r]);
            sum += nums[r];
            if (r - l + 1 == k) {
                maxSum = Math.max(maxSum, sum);
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return maxSum;
    }
}