class Solution {
    static char[][] board;
    static List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        result = new ArrayList<>();

        // Fill board array with dots
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, n);
        return result;
    }

    private static boolean isSafe(int row, int col, int n) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]=='Q')
                return false;
        }
        for (int i = row - 1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (board[i][j]=='Q')
                return false;
        }
        for (int i = row - 1, j=col+1 ; i >=0 && j<n; i--, j++) {
            if (board[i][j]=='Q')
                return false;
        }
        return true;
    }

    private static void solve(int row, int n) {
        if (row == n) {
            addBoard(n);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row,col,n)) {
                board[row][col] = 'Q';
                solve(row + 1, n);
                board[row][col] = '.';
            }
        }
    }
    private static void addBoard(int n) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.add(new String(board[i]));
        }
        result.add(temp);
    }
}

// Solve with The formula 