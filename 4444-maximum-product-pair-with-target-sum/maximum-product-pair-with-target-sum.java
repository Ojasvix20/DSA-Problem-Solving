class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        int[] ans = { -1, -1 };
        int prod = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int need = target - nums[i];
            if (map.containsKey(need) && nums[i]>need) {
                int p = nums[i] * need;
                if (p > prod) {
                    prod=p;
                    ans[0] = i;
                    ans[1] = map.get(need);
                }
            }
        }
        return ans;
    }
}