class Solution {
    public int numIslands(char[][] grid) {
        char[][] grid1 = grid;
        if (grid1 == null || grid1.length == 0)
            return 0;

        int count = 0;
        int rows = grid1.length;
        int cols = grid1[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid1[i][j] == '1') {
                    count++;
                    dfs(grid1, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid1, int i, int j) {
        if (i < 0 || j < 0 || i >= grid1.length || j >= grid1[0].length
                || grid1[i][j] == '0') {
            return;
        }

        grid1[i][j] = '0'; // marked visited

        dfs(grid1, i + 1, j);
        dfs(grid1, i - 1, j);
        dfs(grid1, i, j + 1);
        dfs(grid1, i, j - 1);
    }
}
