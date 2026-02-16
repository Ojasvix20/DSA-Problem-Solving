public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            result <<= 1;          // Shift result left to make space
            result |= (n & 1);     // Get the last bit of n and add it to result
            n >>>= 1;             // Unsigned right shift of n
        }
        
        return result;
    }

}