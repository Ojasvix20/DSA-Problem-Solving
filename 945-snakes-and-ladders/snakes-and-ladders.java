class Solution {
    public int snakesAndLadders(int[][] b) {

        int n = b.length;
        int m = n * n;

        int[] board = new int[m];
        boolean[] vis = new boolean[m];
        int idx = 0;

        boolean leftToRight = true;
        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    board[idx] = b[i][j];
                    idx++;
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    board[idx] = b[i][j];
                    idx++;
                }
            }
            leftToRight = !leftToRight;
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        vis[0] = true;
        int moves = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == m - 1)
                    return moves;
                // vis[curr] = true;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;

                    if (next >= m)
                        continue;

                    if (board[next] != -1) { //found snake/ladder;
                        next = board[next] - 1;
                    }

                    if (!vis[next]) {
                        vis[next] = true;
                        q.offer(next);
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}