class Solution {
    int rows, cols;
    int[] dirX = {0, 0, 1, -1};
    int[] dirY = {1, -1, 0, 0};

    Boolean[][][] dp;
    int[][] visited;

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        rows = grid.size();
        cols = grid.get(0).size();

        dp = new Boolean[rows][cols][health + 1];
        visited = new int[rows][cols];

        return solve(0, 0, grid, health);
    }

    private boolean solve(int i, int j, List<List<Integer>> grid, int health) {

        if (grid.get(i).get(j) == 1) health--;

        if (health <= 0) return false;

        if (i == rows - 1 && j == cols - 1) return true;

        if (dp[i][j][health] != null) return dp[i][j][health];

        visited[i][j] = 1;

        for (int d = 0; d < 4; d++) {
            int nr = i + dirX[d];
            int nc = j + dirY[d];

            if (isValid(nr, nc) && visited[nr][nc] == 0) {
                if (solve(nr, nc, grid, health)) {
                    visited[i][j] = 0;
                    return dp[i][j][health] = true;
                }
            }
        }

        visited[i][j] = 0;
        return dp[i][j][health] = false;
    }

    private boolean isValid(int nr, int nc) {
        return nr >= 0 && nr < rows && nc >= 0 && nc < cols;
    }
}