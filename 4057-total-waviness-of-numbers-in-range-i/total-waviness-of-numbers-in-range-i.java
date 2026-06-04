class Solution {
    public int totalWaviness(int num1, int num2) {

        int n1 = num1;
        int ans = 0;
        while (n1 <= num2) {
            String s = Integer.toString(n1);
            if (s.length() >= 3) {
                int i = 0;
                int j = 1;
                int k = 2;
                while (k < s.length()) {
                    int left = s.charAt(i) - '0';
                    int mid = s.charAt(j) - '0';
                    int right = s.charAt(k) - '0';

                    if (mid > left && mid > right)
                        ans++;
                    if (mid < left && mid < right)
                        ans++;
                    i++;
                    j++;
                    k++;
                }
            }
            n1++;
        }
        return ans;
    }
}