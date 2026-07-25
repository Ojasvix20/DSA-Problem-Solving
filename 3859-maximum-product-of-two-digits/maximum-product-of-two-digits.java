class Solution {
    public int maxProduct(int n) {
        int max=-(int)1e9;
        int secondMax=max;
        int x=n;

        while(x>0){
            int digit= x%10;
            if(digit>=max){
                secondMax=max;
                max=digit;
            }
            else if(digit>secondMax){
                secondMax=digit;
            }
            x=x/10;
        }

        return max*secondMax;
    }
}