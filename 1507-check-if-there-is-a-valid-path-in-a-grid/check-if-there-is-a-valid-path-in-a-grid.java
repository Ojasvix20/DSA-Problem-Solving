class Solution {

    int[][][] dirs = {
            {},
            { { 0, -1 }, { 0, 1 } }, // 1
            { { -1, 0 }, { 1, 0 } }, // 2
            { { 0, -1 }, { 1, 0 } }, // 3
            { { 0, 1 }, { 1, 0 } }, // 4
            { { 0, -1 }, { -1, 0 } }, // 5
            { { 0, 1 }, { -1, 0 } } // 6
    };

    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        return dfs(0, 0, grid, vis);
    }

    public boolean dfs(int r, int c, int[][] grid, boolean[][] vis) {
        int n = grid.length, m = grid[0].length;

        if (r == n - 1 && c == m - 1)
            return true;

        vis[r][c] = true;

        for (int[] d : dirs[grid[r][c]]) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m || vis[nr][nc])
                continue;

            for (int[] back : dirs[grid[nr][nc]]) {
                if (nr + back[0] == r && nc + back[1] == c) {   //check reverse connectivity too
                    if (dfs(nr, nc, grid, vis))
                        return true;
                }
            }
        }

        return false;
    }
}