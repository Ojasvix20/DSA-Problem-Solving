class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> ((b[1] - b[0]) - (a[1] - a[0])));

        // int result=0;

        int l = 0;
        int r = (int) 1e9;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (isPossible(tasks, mid)) {
                // result= mid;
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static boolean isPossible(int[][] tasks, int mid) {
        int n= tasks.length;
        for (int i = 0; i <n; i++) {
            if (mid < tasks[i][1])
                return false;

            mid = mid - tasks[i][0];
        }
        return true;
    }
}