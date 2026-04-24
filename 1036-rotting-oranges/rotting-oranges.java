class Solution {
    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int time = 0;
        int fresh = 0;
        int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                }
                if (grid[i][j] == 1)
                    fresh++;
            }
        }

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            time++;

            for (int i = 0; i < size; i++) {
                Pair curr = q.poll();
                int r = curr.row;
                int c = curr.col;

                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        fresh--;
                        q.offer(new Pair(nr,nc));
                    }
                }

            }
        }

        return (fresh==0)? time: -1;
    }
}