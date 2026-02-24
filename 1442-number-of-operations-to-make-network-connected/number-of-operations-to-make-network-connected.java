class Solution {
    int m=0;
    public int makeConnected(int n, int[][] connections) {

        if(connections.length<n-1)
        {
            return -1;
        }

        int[] rank=new int[n];
        int[] parent=new int[n];
        for(int i=0; i<n; i++)
            {
                rank[i]=0;
                parent[i]=i;
            }

        for(int i=0; i<connections.length; i++)
        {
            unionByRank(rank, parent, connections[i][0], connections[i][1]);
        }

        int ans=n-m-1;
        return ans;
    }
    public void unionByRank(int[] rank, int[] parent, int u, int v)
        {
            int pu=find(parent, u);
            int pv=find(parent, v);
            
            if(pu==pv) return;

            if(rank[pu]<rank[pv])
            {
                parent[pu]=pv;
            }
            else if(rank[pv]<rank[pu])
            {
                parent[pv]=pu;
            }
            else
            {
                parent[pv]=pu;
                rank[pu]=rank[pu]+1;
            }
            m++;
            return;
        }
    public int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        }

        // Path compression
        parent[i] = find(parent, parent[i]); 
        return parent[i];
    }
}