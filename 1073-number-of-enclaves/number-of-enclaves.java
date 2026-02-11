class Solution {

    int m, n;
    int total;

    int[] dr = { 1, -1, 0, 0 };
    int[] dc = { 0, 0, 1, -1 };

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        total = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    total += 1;
            }
        }

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1 && !visited[i][0])
                dfs(i, 0, grid, visited);

            if (grid[i][n - 1] == 1 && !visited[i][n - 1])
                dfs(i, n - 1, grid, visited);
        }
        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1 && !visited[0][j])
                dfs(0, j, grid, visited);
            if (grid[m - 1][j] == 1 && !visited[m - 1][j])
                dfs(m - 1, j, grid, visited);
        }

        return total;
    }

    private void dfs(int r, int c, int[][] grid, boolean[][] visited) {
        if (grid[r][c] == 0 || visited[r][c])
            return;
        visited[r][c] = true;
        total -= 1;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (isValid(nr, nc)) {
                dfs(nr, nc, grid, visited);
            }
        }
    }

    private boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }
}