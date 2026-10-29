class Solution {
    public int peakValleyDifference(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int peaks = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                peaks += nums[i];
        }
        int valleys = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1])
                valleys += nums[i];

        }

        return ans=(peaks-valleys);
    }
}