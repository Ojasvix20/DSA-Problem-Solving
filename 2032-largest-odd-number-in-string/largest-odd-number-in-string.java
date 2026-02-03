class Solution {
    public String largestOddNumber(String num) {
        int i=-1;
        int n = num.length();
        for(int x=n-1; x>=0; x--){
            char c = num.charAt(x);
            if((c-'0')%2!=0)  {
                i=x;
                break;
            } 
        }
        if (i==-1) return "";
        String subStr = num.substring(0,i+1);
        return subStr;
    }
}