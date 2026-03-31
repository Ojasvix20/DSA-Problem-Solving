class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int top = 0, bottom = n - 1, left = 0, right = m - 1;

        List<Integer> ans = new ArrayList<>();

        int dir = 0;
        // dir-0: left to right
        // dir-1: top to bottom
        // dir-2: right to left
        // dir-3: bottom to up

        while(top<=bottom && left<=right) {

            if (dir == 0) {
                //left to tright
                for (int j = left; j <= right; j++) {
                    ans.add(matrix[top][j]);
                }
                top++;
            }
            else if (dir == 1) {
                // top to bottom
                for (int j = top; j <= bottom; j++) {
                    ans.add(matrix[j][right]);
                }
                right--;
            }
            else if (dir == 2) {
                // right to left
                for (int j = right; j >= left; j--) {
                    ans.add(matrix[bottom][j]);
                }
                bottom--;
            }
            else if (dir == 3) {
                // bottom to up
                for (int j = bottom; j >= top; j--) {
                    ans.add(matrix[j][left]);
                }
                left++;
            }
            dir = (dir+1)%4;
        }

        return ans;
    }
}