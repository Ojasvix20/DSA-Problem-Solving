class Solution {
    public boolean increasingTriplet(int[] nums) {
        //maintain a prefix-min and suffix-max array
        int n = nums.length;
        int[] prefixMin = new int[n];
        int[] sufixMax = new int[n];
        prefixMin[0] = nums[0];
        sufixMax[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufixMax[i] = Math.max(sufixMax[i + 1], nums[i]);
        }
        for (int i = 1; i < n; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], nums[i]);

            if (prefixMin[i] < nums[i] && sufixMax[i] > nums[i])
                return true;

        }

        return false;

    }
}