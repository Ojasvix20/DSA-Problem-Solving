class Solution {
    public int[] distributeCandies(int candies, int n) {
        int[] res = new int[n];
        int give = 1, i = 0;

        while (candies > 0) {
            if (give > candies) give = candies;
            res[i] += give;
            candies -= give;
            give++;
            if (++i == n) i = 0;
        }

        return res;
    }
}