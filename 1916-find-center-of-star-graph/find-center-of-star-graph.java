class Solution {
    public int findCenter(int[][] edges) {
        int m=edges.length;
        int n=m+1;
        int maxNode = 0;
        for (int[] e : edges) {
            maxNode = Math.max(maxNode, Math.max(e[0], e[1]));
        }

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m; i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);

        }
	    for(int i=1; i<=maxNode;i++){
	    	if(adj.get(i).size()==edges.length){
	    		return i;
	    	}
	    }
        return -1;
    }
}