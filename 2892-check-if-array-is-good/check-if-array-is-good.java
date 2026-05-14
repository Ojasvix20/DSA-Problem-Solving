class Solution {
    public boolean isGood(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);
        int  max = nums[n-1];
        int[] base = new int[max+1];
        if(base.length!= n) return false;

        for(int i=0; i<base.length-1; i++){
            base[i]=i+1;
        }
        base[base.length-1]=max;
        base[base.length-2]=max;

        for(int i=0; i<n; i++){
            if(nums[i]!=base[i]) return false;
        }

        return true;
    }
}