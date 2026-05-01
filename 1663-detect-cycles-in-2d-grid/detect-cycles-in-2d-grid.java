class Solution {
    static int n, m;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

    public boolean containsCycle(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!vis[i][j]){
                    if(dfs(i, j, -1, -1, grid, vis)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(int r, int c, int pr, int pc, char[][] grid, boolean[][] vis){

        vis[r][c] = true;

        for(int[] d : dir){
            int nr = r + d[0];
            int nc = c + d[1];


            if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;


            if(grid[nr][nc] != grid[r][c]) continue;


            if(!vis[nr][nc]){
                if(dfs(nr, nc, r, c, grid, vis)) return true;
            }
            else if(nr != pr || nc != pc){
                return true;
            }
        }

        return false;
    }
}