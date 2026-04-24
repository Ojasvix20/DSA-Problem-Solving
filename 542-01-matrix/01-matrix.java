class Solution {
    static int n, m;
    static int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[][] updateMatrix(int[][] mat) {
        n = mat.length;
        m = mat[0].length;
        int[][] ans = new int[n][m];
        for (int[] row : ans) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[] { i, j });
                    ans[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r=curr[0];
            int c= curr[1];

            for(int[] d: dir){
                int nr= r+d[0];
                int nc= c+d[1];

                if(isValid(nr,nc) && ans[nr][nc]==-1){
                    ans[nr][nc]= ans[r][c]+1;
                    q.offer(new int[]{nr,nc});
                }
            }
        }
        return ans;
        
    }
    boolean isValid(int nr, int nc){
        return (nr>=0 && nr<n && nc>=0 && nc<m);
    }
}