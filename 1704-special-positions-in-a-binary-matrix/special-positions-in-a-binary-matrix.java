class Solution {
    public int numSpecial(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(mat[i][j] == 1){

                    boolean special = true;

                    // check column
                    for(int x = 0; x < n; x++){
                        if(x != i && mat[x][j] == 1){
                            special = false;
                            break;
                        }
                    }

                    // check row
                    for(int x = 0; x < m; x++){
                        if(x != j && mat[i][x] == 1){
                            special = false;
                            break;
                        }
                    }

                    if(special) ans++;
                }
            }
        }

        return ans;
    }
}