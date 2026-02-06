class Solution {
    static int m;
    static int n;
    public int numEnclaves(int[][] grid) {
        m= grid.length;
        n= grid[0].length;
        int count=0
        ;
        for(int i=0; i<m; i++){
            if(grid[i][0]==1) dfs(i,0,grid);
            if(grid[i][n-1]==1) dfs(i,n-1,grid);
        }
        for(int j=0; j<n; j++) {
            if(grid[0][j] == 1)dfs(0, j, grid);
            if(grid[m-1][j] == 1)dfs(m-1, j, grid);
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                   count++;
                }
            }
        }
        return count;

    }
    int[] dRow = {0, 1, 0, -1};
    int[] dCol = {-1, 0, 1, 0};
    public void dfs(int i, int j, int[][] grid){
        grid[i][j]=2;
        for(int k=0; k<4; k++){
            int row = i+dRow[k];
            int col = j+dCol[k];
            if (row < 0 || col < 0 || row >= m || col >= n ||  grid[row][col]!=1)continue;
            dfs(row, col, grid);
        }
    }
}
