class Solution {
    public boolean checkString(String s) {
        int lastA = -1;
        int firstB = -1;

        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                lastA = i;
            }
            if (s.charAt(i) == 'b' && firstB == -1) {
                firstB = i;
            }
        }

        return ((lastA==-1) || (firstB==-1) || (lastA<firstB))? true : false;
    }
}