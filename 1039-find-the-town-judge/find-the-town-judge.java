class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length==0 && n==1)return 1;
        int[] indegree = new int[n + 1];
        int[] outdegree = new int[n + 1];

        for (int i = 0; i < trust.length; i++) {
            outdegree[trust[i][0]]++;
            indegree[trust[i][1]]++;
        }
        for (int i = 0; i <= n; i++) {
            if(indegree[i]==n-1 && outdegree[i]==0) return i;
        }
        return -1;
    }
}