class Solution {
    static int[] x;                   // x[k] = column of queen in row k
    static List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        x = new int[n];
        result = new ArrayList<>();

        place(0, n);
        return result;
    }

    private static void place(int k, int n) {
        if (k == n) {
            addBoard(n);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(k, col)) {
                x[k] = col;           // place queen mathematically
                place(k + 1, n);
            }
        }
    }

    private static boolean isSafe(int k, int col) {
        for (int j = 0; j < k; j++) {

            // Same column check
            if (x[j] == col) return false;

            // Diagonal check using |x[j] - col| == |j - k|
            if (Math.abs(x[j] - col) == Math.abs(j - k))
                return false;
        }
        return true;
    }

    private static void addBoard(int n) {
        List<String> temp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[x[i]] = 'Q';
            temp.add(new String(row));
        }

        result.add(temp);
    }
}

// Solve with The formula 
// Place(k,i){
//     for(j=1 to n){
//         (x[j-1])=(j-k)
//     }
// }