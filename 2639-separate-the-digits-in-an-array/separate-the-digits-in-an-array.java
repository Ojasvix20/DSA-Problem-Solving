class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int num: nums){
            List<Integer> temp = new ArrayList<>();
            while(num>0){
                int digit = num%10;
                temp.add(digit);
                num/=10;
            }
            Collections.reverse(temp);
            for (int digit : temp) {
                ans.add(digit);
            }
        }
        int n= ans.size();
        int[] arr =new int[n];
        for(int i=0; i<n; i++){
            arr[i]= ans.get(i);
        }
        return arr;
    }
}