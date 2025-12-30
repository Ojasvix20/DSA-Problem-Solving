class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] arr = new int[2];
        int idx=0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
               arr[idx] = (nums[i]);
                idx++;
            }else{
                set.add(nums[i]);
            }

        }
        return arr;
    }
}