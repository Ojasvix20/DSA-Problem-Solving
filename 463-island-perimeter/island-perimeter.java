class Solution {
    static int n, m;
    static int count=0;
    static int[][] dir ={{0,1},{1,0},{0,-1},{-1,0}};
    public int islandPerimeter(int[][] grid) {
        n= grid.length;
        m= grid[0].length;
        boolean[][] vis= new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    return dfs(i,j,grid, vis);
                }
            }
        }
        return 0;

    }
    public static int dfs(int r, int c, int[][] grid, boolean [][] vis){
        if(r<0 || r>=n || c<0 || c>=m || grid[r][c]==0) return 1;

        if(vis[r][c] ) return 0;
        vis[r][c]=true;
        
        int perimeter=0;

        for(int[] d: dir){
            int nr = r+d[0];
            int nc = c+d[1];

            perimeter += dfs(nr, nc, grid, vis);
        }
        return perimeter;

    }
}