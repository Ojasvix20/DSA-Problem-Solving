class Solution {
    public int mirrorDistance(int n) {
        int m=n;
        int rev=0;
        while(m>0){
            int dig = m%10;
            m/=10;
            rev = rev*10+ dig;
        }

        return Math.abs(rev-n);
    }
}