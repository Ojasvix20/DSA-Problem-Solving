class Solution {
public:
    int fn(int i , int j , vector<vector<int>>& grid , int n , int m , int& zerocnt , int cnt){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == -1 || grid[i][j] == -2){
            return 0;
        }
        if(grid[i][j] == 2 && cnt == zerocnt) return 1;

        int temp = grid[i][j];
        grid[i][j] = -2;
        int up = fn(i-1 , j , grid , n , m , zerocnt , cnt+1);
        int down = fn(i+1 , j , grid , n , m , zerocnt , cnt+1);
        int left = fn(i , j-1 , grid , n , m , zerocnt , cnt+1);
        int right = fn(i , j+1 , grid , n , m , zerocnt , cnt+1);
        grid[i][j] = temp;

        return up+down+left+right;
    }
    int uniquePathsIII(vector<vector<int>>& grid) {
        int n = grid.size() , m = grid[0].size() , zerocnt = 0;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 0){
                    zerocnt++;
                }
            }
        }
        
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    ans = fn(i , j , grid , n , m , zerocnt , -1);
                    break;
                }
            }
        }

        return ans;
    }
};