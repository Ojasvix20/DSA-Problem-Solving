class Pair {
    int row, col;

    Pair(int r, int c) {
        this.row = r;
        this.col = c;
    }
}

class Solution {
    static int[] dirX = { 0, 1, 1, -1, 1, -1, -1, 0 };
    static int[] dirY = { 1, 0, 1, -1, -1, 1, 0, -1 };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1)
            return -1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));
        int ans = 1;
        boolean[][] vis = new boolean[n][m];
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {

                Pair curr = q.poll();
                int r = curr.row;
                int c = curr.col;

                if (r == n - 1 && c == m - 1)
                    return ans;
                for (int d = 0; d < 8; d++) {
                    int nr = r + dirX[d];
                    int nc = c + dirY[d];
                    if (nr >= 0 && nc >= 0 && nc < m && nr < n) {
                        if (grid[nr][nc] == 0 && !vis[nr][nc]) {
                            q.offer(new Pair(nr, nc));
                            vis[nr][nc] = true;
                        }
                    }
                }
            }
                ans++;

        }
        return -1;
    }
}