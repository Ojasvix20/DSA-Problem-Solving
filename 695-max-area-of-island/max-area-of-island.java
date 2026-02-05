class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] grid1 = grid;
        if (grid1 == null || grid1.length == 0)
            return 0;

        int areaMax = 0;
        int rows = grid1.length;
        int cols = grid1[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid1[i][j] == 1) {
                    int currArea = dfs(grid1, i, j);
                    areaMax = Math.max(areaMax, currArea);
                }
            }
        }
        return areaMax;
    }

    private static int dfs(int[][] grid1, int i, int j) {
        if (i < 0 || j < 0 || i >= grid1.length || j >= grid1[0].length
                || grid1[i][j] == 0) {
            return 0;
        }
        grid1[i][j]=0; //mark visited to avoid re-visit

        int area = 1;

        area += dfs(grid1, i + 1, j);
        area += dfs(grid1, i - 1, j);
        area += dfs(grid1, i, j + 1);
        area += dfs(grid1, i, j - 1);

        return area;
    }
}