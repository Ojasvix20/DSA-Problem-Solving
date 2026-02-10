// nearest ---- BFS
//but bfs from each 1 to nearest 0 would be too much complexity
// rather to bfs from 0 to 1
class Solution {
    static int m, n;

    public int[][] updateMatrix(int[][] mat) {
        n = mat.length;
        m = mat[0].length;

        int[][] ans = new int[n][m];
        for(int[] row: ans){
            Arrays.fill(row,-1);
        }
        Queue<int[]> q = new LinkedList<>();

        //offer 0s into the q first...
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                    ans[i][j]=0;
                }
            }
        }

        //simple BFS traversal:

        while(!q.isEmpty()){
            int[] curr= q.poll();
            int x = curr[0];
            int y = curr[1];

            //check all nbrs for visited and validity... then add to q.
            if(checkValid(x+1,y) && ans[x+1][y]==-1){
                q.offer(new int[]{x+1,y});
                ans[x+1][y]=ans[x][y]+1;
            }
            if(checkValid(x-1,y) && ans[x-1][y]==-1){
                q.offer(new int[]{x-1,y});
                ans[x-1][y]=ans[x][y]+1;
            }
            if(checkValid(x,y+1) && ans[x][y+1]==-1){
                q.offer(new int[]{x,y+1});
                ans[x][y+1]=ans[x][y]+1;
            }
            if(checkValid(x,y-1) && ans[x][y-1]==-1){
                q.offer(new int[]{x,y-1});
                ans[x][y-1]=ans[x][y]+1;
                
            }
        }
        return ans;
    }
    public static boolean checkValid(int x, int y){
        if(x<0 || y<0 ||x>=n || y>=m) return false;
    
        return true;
    }
}
