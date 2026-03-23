class Solution {
    public int[] replaceElements(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<arr.length-1; i++){
            int max = Integer.MIN_VALUE;
            for(int j=i+1; j<arr.length; j++){
                max = Math.max(arr[j],max);
            }
            ans.add(max);
            
        }
        ans.add(-1);
        int[] ansArr=  new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            ansArr[i]=ans.get(i);
        }
        
        return ansArr;
    }
}